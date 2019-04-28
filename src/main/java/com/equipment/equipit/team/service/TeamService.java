package com.equipment.equipit.team.service;

import com.equipment.equipit.team.db.TeamRepository;
import com.equipment.equipit.team.model.TeamDTO;
import com.equipment.equipit.team.model.TeamEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    public TeamService(TeamRepository teamRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }

    public Page<TeamEntity> findAll(Pageable pageable) {
        final Page<TeamEntity> results = teamRepository.findAll(pageable);
        results.map(entity -> modelMapper.map(entity, TeamDTO.class));
        return results;
    }
}
