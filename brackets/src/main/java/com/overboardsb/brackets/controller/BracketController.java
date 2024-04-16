package com.overboardsb.brackets.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.model.BracketRequest;
import com.overboardsb.brackets.services.BracketService;
import com.overboardsb.brackets.dao.repository.BracketRepository;
import com.overboardsb.brackets.domain.entity.Bracket;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BracketController {

	@Autowired
	private BracketService bracketService;

	@Autowired
	private BracketRepository bracketRepository;
	
	@GetMapping("/bracket/{bracketId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Bracket getBracketByBracketId(@NonNull @PathVariable("bracketId") Integer bracketId) throws SQLException {
		return bracketService.getAllBrackets(bracketId);
	}

	@PostMapping("/bracket")
	@CrossOrigin(origins = "http://localhost:3000")
	public String postBracket(@RequestBody BracketRequest entity) {
		Bracket bracket = new Bracket();
		bracket.setName(entity.getName());
		bracket.setRounds(entity.getRounds());
		bracketRepository.save(bracket);
		
		return "Update successful";
	}
	
}
