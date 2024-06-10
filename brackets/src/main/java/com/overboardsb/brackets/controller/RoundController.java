package com.overboardsb.brackets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.model.request.RoundRequest;
import com.overboardsb.brackets.services.RoundMatchesService;
import com.overboardsb.brackets.services.RoundService;

@RestController
public class RoundController {

	@Autowired
	private RoundService roundService;

	@Autowired
	private RoundMatchesService roundMatchesService;

    /*@GetMapping("/round/{roundId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public RoundResponse getRoundByRoundId(@NonNull @PathVariable("roundId") Integer roundId) throws SQLException {
		return roundService.getRoundByRoundId(roundId);
	}*/

	@PostMapping("/round")
	@CrossOrigin(origins = "http://localhost:3000")
	public String postRound(@RequestBody RoundRequest entity) {

		roundService.createRound(entity);
		return "Update successful";
	}

	/*@PostMapping("/roundMatches")
	@CrossOrigin(origins = "http://localhost:3000")
	public String postRoundMatches(@RequestBody RoundMatchesRequest entity) {

		roundMatchesService.createRoundMatches(entity);
		return "Update successful";
	}*/
    
}
