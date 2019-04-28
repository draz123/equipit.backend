package com.equipment.equipit.team.db;

import com.equipment.equipit.team.model.TeamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<TeamEntity, UUID> {

    @Override
    Page<TeamEntity> findAll(Pageable pageable);
}
