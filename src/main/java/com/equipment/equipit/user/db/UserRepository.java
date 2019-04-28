package com.equipment.equipit.user.db;

import com.equipment.equipit.user.model.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, UUID> {

    boolean exists(Example<UserEntity> matcher);

    UserEntity findByEmail(@Param("email") String email);

}
