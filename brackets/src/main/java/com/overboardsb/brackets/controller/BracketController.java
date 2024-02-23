package com.overboardsb.brackets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.model.TeamRequest;
import com.overboardsb.brackets.repository.TeamRepository;
import com.overboardsb.brackets.repository.entity.Team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
public class BracketController {

	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping("/bracket")
	public Iterable<Team> getAllBrackets() {
		return teamRepository.findAll();
	}

	@PostMapping("/team")
	public String postMethodName(
		@RequestBody TeamRequest entity
	) {
		Team team = new Team();
		team.setName(entity.getName());
		team.setPlayers(entity.getPlayers());
		teamRepository.save(team);
		
		return "Update successful";
	}
	
}
