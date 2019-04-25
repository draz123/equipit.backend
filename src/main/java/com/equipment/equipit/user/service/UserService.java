package com.equipment.equipit.user.service;

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

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDTO createUser(UserCreateRequest userCreateRequest) {
        UserEntity userEntity = new UserEntity(userCreateRequest.getEmail(), bCryptPasswordEncoder.encode(userCreateRequest.getPassword()), GroupType.USER);
        if (!checkIfRecordExists(userCreateRequest.getEmail())) {
            UserEntity savedEntity = userRepository.save(userEntity);
            return UserDTO.builder()
                    .email(savedEntity.getEmail())
                    .groupType(savedEntity.getGroupType())
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
