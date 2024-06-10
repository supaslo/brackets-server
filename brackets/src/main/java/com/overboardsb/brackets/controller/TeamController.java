package com.overboardsb.brackets.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.domain.entity.Team;
import com.overboardsb.brackets.model.request.TeamRequest;
import com.overboardsb.brackets.services.TeamService;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/team/{teamId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Team getRoundByRoundId(@NonNull @PathVariable("teamId") Integer teamId) throws SQLException {
		return teamService.getTeamById(teamId);
	}

    @GetMapping("/teams")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Team> getAllTeams() throws SQLException {
		return teamService.getAllTeams();
	}

    @PostMapping("/team")
    @CrossOrigin(origins = "http://localhost:3000")
    public String postTeam(@RequestBody TeamRequest team) {
        
        teamService.createTeam(team);
        return "Update successful";
    }
    

}
