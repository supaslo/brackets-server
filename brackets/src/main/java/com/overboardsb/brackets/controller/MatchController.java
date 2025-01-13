package com.overboardsb.brackets.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.model.response.MatchResponse;
import com.overboardsb.brackets.services.MatchService;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/match/{matchId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public MatchResponse getMatchByMatchId(@NonNull @PathVariable("matchId") Integer matchId) throws SQLException {

        return matchService.getMatchByMatchId(matchId);
        
	}

    /*@PostMapping("/match")
	@CrossOrigin(origins = "http://localhost:3000")
	public String postRound(@RequestBody MatchRequest matchRequest) {

		matchService.createMatch(matchRequest);
		return "Update successful";
	}*/

}
