package com.overboardsb.brackets.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.overboardsb.brackets.model.request.TournamentRequest;
import com.overboardsb.brackets.model.response.TournamentResponse;
import com.overboardsb.brackets.services.RegistrationService;
import com.overboardsb.brackets.services.TournamentService;

@RestController
@RequestMapping(value = "/tournaments")
public class TournamentController {

	@Autowired
	private RegistrationService registrationService;

    @Autowired
	private TournamentService tournamentService;

	@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/tournament/{tournamentId}")
	public String deleteRegistration(@NonNull @PathVariable("tournamentId") Integer tournamentId) throws SQLException {
		return tournamentService.deleteTournament(tournamentId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/tournaments")
	public ArrayList<TournamentResponse> getTournaments(@RequestParam(name = "registrations", required = false) Integer registrationCount) throws SQLException {
		if (registrationCount != null) {
			List<Integer> tournamentIds = registrationService.getRegistrationTournamentIds();
			return tournamentService.getTournaments(tournamentIds);
		} else {
			return tournamentService.getTournaments();
		}
	}	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/tournament/{tournamentId}")
	public TournamentResponse getTournamentByTournamentId(@NonNull @PathVariable("tournamentId") Integer tournamentId) throws SQLException {
		return tournamentService.getTournamentByTournamentId(tournamentId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PatchMapping("/tournament/{tournamentId}")
    public TournamentResponse patchTournament(@NonNull @PathVariable("tournamentId") Integer tournamentId, @RequestBody TournamentRequest tournament) {
    	return tournamentService.updateTournament(tournament);
    }	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/tournament")
    public TournamentResponse postTournament(@RequestBody TournamentRequest tournament) {
        
        return tournamentService.createTournament(tournament);

    }
    
}
