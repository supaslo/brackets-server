package com.overboardsb.brackets.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.services.BracketService;
import com.overboardsb.brackets.model.response.BracketResponse;

@RestController
public class BracketController {

	@Autowired
	private BracketService bracketService;

	/*@Autowired
	private BracketRepository bracketRepository;*/
	
	@GetMapping("/bracket/{bracketId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public BracketResponse getBracketByBracketId(@NonNull @PathVariable("bracketId") Integer bracketId) throws SQLException {
		return bracketService.getBracketById(bracketId);
	}

	/*@GetMapping("/rounds/{bracketId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ArrayList<BracketRoundsResponse> getRoundsByBracketId(@NonNull @PathVariable("bracketId") Integer bracketId) throws SQLException {
		return bracketService.getAllRoundsForBracket(bracketId);
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

	@PostMapping("/bracketRounds")
	@CrossOrigin(origins = "http://localhost:3000")
	public String postBracketRounds(@RequestBody BracketRoundsRequest entity) {

		bracketService.createBracketRounds(entity);
		return "Update successful";
	}*/
	
}
