package com.wilzsoft.brackets.brackets_server.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wilzsoft.brackets.brackets_server.model.response.MatchResponse;
import com.wilzsoft.brackets.brackets_server.services.MatchService;

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
