package com.equipment.equipit.team.controller;

import com.equipment.equipit.team.model.TeamEntity;
import com.equipment.equipit.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;


    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public Page<TeamEntity> getAllTeams(Pageable pageable) {
        return teamService.findAll(pageable);
    }
}
