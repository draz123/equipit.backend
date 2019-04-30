package com.equipment.equipit.user.service;

import com.equipment.equipit.team.db.TeamRepository;
import com.equipment.equipit.team.model.TeamEntity;
import com.equipment.equipit.user.db.UserRepository;
import com.equipment.equipit.user.model.GroupType;
import com.equipment.equipit.user.model.UserCreateRequest;
import com.equipment.equipit.user.model.UserDTO;
import com.equipment.equipit.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TeamRepository teamRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.teamRepository = teamRepository;
    }

    public UserDTO createUser(UserCreateRequest userCreateRequest) {
        TeamEntity teamEntity = teamRepository.findById(userCreateRequest.getTeamId()).orElseThrow(() -> new IllegalStateException("No team found"));
        UserEntity userEntity = new UserEntity(userCreateRequest.getEmail(), bCryptPasswordEncoder.encode(userCreateRequest.getPassword()),
                GroupType.USER, teamEntity, userCreateRequest.getPosition());
        if (!checkIfRecordExists(userCreateRequest.getEmail())) {
            UserEntity savedEntity = userRepository.save(userEntity);
            return UserDTO.builder()
                    .email(savedEntity.getEmail())
                    .id(savedEntity.getId())
                    .build();
        }
        throw new IllegalStateException("User not created");
    }

    public boolean checkIfRecordExists(String email) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id", "password");
        UserEntity requestedUser = new UserEntity();
        requestedUser.setEmail(email);
        Example<UserEntity> checker = Example.of(requestedUser, exampleMatcher);
        return userRepository.exists(checker);
    }
}
