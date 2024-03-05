package com.overboardsb.brackets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.model.Bracket;
import com.overboardsb.brackets.model.TeamRequest;
import com.overboardsb.brackets.repository.TeamsRepository;
import com.overboardsb.brackets.repository.entity.Teams;
import com.overboardsb.brackets.services.BracketService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
public class BracketController {

	private BracketService bracketService;

	@Autowired
	private TeamsRepository teamRepository;

	@Autowired
	public void setBracketService(BracketService bracketService) {
		this.bracketService = bracketService;
	}
	
	@GetMapping("/bracket")
	@CrossOrigin(origins = "http://localhost:3000")
	public Bracket getAllBrackets() {
		return bracketService.getAllBrackets();
	}

	@PostMapping("/teams")
	public String postMethodName(
		@RequestBody TeamRequest entity
	) {
		Teams team = new Teams();
		team.setName(entity.getName());
		team.setPlayers(entity.getPlayers());
		teamRepository.save(team);
		
		return "Update successful";
	}
	
}
