package com.wilzsoft.brackets.brackets_server.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilzsoft.brackets.brackets_server.model.request.RegistrationRequest;
import com.wilzsoft.brackets.brackets_server.model.request.TournamentRequest;
import com.wilzsoft.brackets.brackets_server.model.response.RegistrationResponse;
import com.wilzsoft.brackets.brackets_server.model.response.TournamentResponse;
import com.wilzsoft.brackets.brackets_server.services.RegistrationService;

import lombok.NonNull;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/registration/{registrationId}")
	public String deleteRegistration(@NonNull @PathVariable("registrationId") Integer registrationId) throws SQLException {
		return registrationService.deleteRegistration(registrationId);
	}

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/registration")
	public ArrayList<RegistrationResponse> getRegistrations() throws SQLException {
		return registrationService.getRegistrations();
	}

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/registration/{tournamentId}")
	public RegistrationResponse getRegistrationByTournamentId(@NonNull @PathVariable("tournamentId") Integer tournamentId) throws SQLException {
		return registrationService.getRegistrationByTournamentId(tournamentId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PatchMapping("/registration/{tournamentId}")
    public RegistrationResponse patchTournament(@NonNull @PathVariable("tournamentId") Integer tournamentId, @RequestBody RegistrationRequest registration) {
    	return registrationService.updateRegistration(registration);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registration")
    public String postPlayer(@RequestBody RegistrationRequest registration) {
        
        return registrationService.createRegistration(registration);

    }
    
}
