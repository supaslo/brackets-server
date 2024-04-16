package com.overboardsb.brackets.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.domain.entity.Round;
import com.overboardsb.brackets.model.RoundRequest;
import com.overboardsb.brackets.services.RoundService;

@RestController
public class RoundController {

	@Autowired
	private RoundService roundService;

    @GetMapping("/round/{roundId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public Iterable<Round> getRoundByRoundId(@NonNull @PathVariable("roundId") Integer roundId) throws SQLException {
		return roundService.getRoundByBracketId(roundId);
	}

	@PostMapping("/round")
	@CrossOrigin(origins = "http://localhost:3000")
	public String postRound(@RequestBody RoundRequest entity) {

		roundService.createRound(entity);
		return "Update successful";
	}
    
}
