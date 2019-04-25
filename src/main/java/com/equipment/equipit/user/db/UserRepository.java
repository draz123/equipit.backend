package com.equipment.equipit.user.db;

import com.equipment.equipit.user.model.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    boolean exists(Example<UserEntity> matcher);

    UserEntity findByEmail(String email);

}
