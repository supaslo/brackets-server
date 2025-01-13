package com.overboardsb.brackets.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.RegistrationRepository;
import com.overboardsb.brackets.domain.entity.Registration;
import com.overboardsb.brackets.model.request.RegistrationRequest;
import com.overboardsb.brackets.model.response.PlayerResponse;
import com.overboardsb.brackets.model.response.RegisteredPlayerResponse;
import com.overboardsb.brackets.model.response.RegistrationResponse;
import com.overboardsb.brackets.model.response.TournamentResponse;
import com.overboardsb.brackets.model.request.RegisteredPlayerRequest;
import com.overboardsb.brackets.dao.repository.PlayerRepository;
import com.overboardsb.brackets.domain.entity.Player;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private PlayerService playerService;

    public String createRegistration(RegistrationRequest registration) {

        for(RegisteredPlayerRequest registeredPlayer: registration.getRegisteredPlayerList()) {

            Registration newRegistration = new Registration();
            Player player = new Player();
            Player newPlayer = new Player();

            if (registeredPlayer.getPlayer().getLastName().length() > 0) {
                player.setFirstname(registeredPlayer.getPlayer().getFirstName());
                player.setLastname(registeredPlayer.getPlayer().getLastName());
                newPlayer = playerRepository.save(player);
                newRegistration.setPlayerId(newPlayer.getId());
                newRegistration.setPaid(registeredPlayer.isPaid());
                newRegistration.setPlayerTournamentLevel(registeredPlayer.getPlayer().getLevel());
            } else {
                return "Trying to add new player, but no player information found.";
            }

            newRegistration.setPlayerTournamentLevel(registeredPlayer.getPlayer().getLevel());
            newRegistration.setTournamentId(registration.getTournamentId());

            registrationRepository.save(newRegistration);

        }

        return "Registration Complete";
        
    }

    public String deleteRegistration(Integer tournamentId) {
        List<Registration> registrations = registrationRepository.findAllByTournamentId(tournamentId);
        for (Registration registration: registrations) {
            registrationRepository.deleteById(registration.getId());
        }
        return("Successful Delete");
    }

    public ArrayList<RegistrationResponse> getRegistrations() {

        ArrayList<RegistrationResponse> registrationResponseList = new ArrayList<>();
        List<Registration> registrations = registrationRepository.findAll();
        Integer previousTournamentId = 0;

        for (Registration registration: registrations) {

            if (registration.getTournamentId().intValue() == previousTournamentId.intValue()) {
                previousTournamentId = registration.getTournamentId();
            } else {
                RegistrationResponse registrationResponse = getRegistrationByTournamentId(registration.getTournamentId());
                registrationResponseList.add(registrationResponse);
                previousTournamentId = registration.getTournamentId();
            }
        }
        
        return registrationResponseList;
    }

    public RegistrationResponse getRegistrationByTournamentId(Integer tournamentId) {

        RegistrationResponse registrationResponse = new RegistrationResponse();
        ArrayList<RegisteredPlayerResponse> registeredPlayerList = new ArrayList<>();

        //Get tournament information
        TournamentResponse tournamentResponse = tournamentService.getTournamentByTournamentId(tournamentId);
        registrationResponse.setTournamentRegistered(tournamentResponse);

        //Check if everyone has paid
        if(registrationRepository.countNonPaidRegistrations(tournamentId) > 0) {
            registrationResponse.setEverybodyPaid(false);
        } else {
            registrationResponse.setEverybodyPaid(true);
        }

        //Get player count
        registrationResponse.setPlayerCount(registrationRepository.countByTournamentId(tournamentId));

        /*DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        registrationResponse.setDate(dateFormat.format(tournamentResponse.getDate()));*/

        //Get player information
        Iterable<Registration> registrations = registrationRepository.findAllByTournamentId(tournamentId);
        for (Registration registration: registrations) {

            RegisteredPlayerResponse registeredPlayerResponse = new RegisteredPlayerResponse();
            PlayerResponse playerResponse = new PlayerResponse();

            //Get player
            Player player = playerService.getPlayerByPlayerId(registration.getPlayerId());
            playerResponse.setId(player.getId());
            playerResponse.setFirstName(player.getFirstname());
            playerResponse.setLastName(player.getLastname());
            playerResponse.setGender(player.getGender());
            playerResponse.setLevel(registration.getPlayerTournamentLevel());

            //Get registered player information
            registeredPlayerResponse.setId(registration.getId());
            registeredPlayerResponse.setPaid(registration.isPaid());
            registeredPlayerResponse.setPlayer(playerResponse);

            //Set registered player
            registeredPlayerList.add(registeredPlayerResponse);

        }

        registrationResponse.setRegisteredPlayerList(registeredPlayerList);
        
        return registrationResponse;
    }

    public List<Integer> getRegistrationTournamentIds() {
        List<Integer> tournamentIds = new ArrayList<>();
        List<Registration> registrations = registrationRepository.findAll();
        for (Registration registration: registrations) {
            tournamentIds.add(registration.getTournamentId());
        }
        return tournamentIds;
    }

    public RegistrationResponse updateRegistration(RegistrationRequest registration) {

        for(RegisteredPlayerRequest registeredPlayer: registration.getRegisteredPlayerList()) {

            Registration modifiedRegistration = new Registration();
            Player player = new Player();
            Player newPlayer = new Player();

            if (registeredPlayer.getPlayer().getLastName().length() > 0) {
                if (registeredPlayer.getId() == 0) {
                    player.setFirstname(registeredPlayer.getPlayer().getFirstName());
                    player.setLastname(registeredPlayer.getPlayer().getLastName());
                    newPlayer = playerRepository.save(player);
                    modifiedRegistration.setPlayerId(newPlayer.getId());
                } else {
                    modifiedRegistration.setPlayerId(registeredPlayer.getId());
                }
                modifiedRegistration.setPaid(registeredPlayer.isPaid());
                modifiedRegistration.setPlayerTournamentLevel(registeredPlayer.getPlayer().getLevel());
                modifiedRegistration.setId(registeredPlayer.getId());
            }
            modifiedRegistration.setTournamentId(registration.getTournamentId());
            registrationRepository.save(modifiedRegistration);

        }

        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setTournamentRegistered(tournamentService.getTournamentByTournamentId(registration.getTournamentId()));
        registrationResponse.setPlayerCount(registrationRepository.countByTournamentId(registration.getTournamentId()));
        registrationResponse.setEverybodyPaid(registrationRepository.countNonPaidRegistrations(registration.getTournamentId()) > 0 ? false : true);

        List<Registration> updatedRegistrations = registrationRepository.findAllByTournamentId(registration.getTournamentId());
        for (Registration updatedRegistration: updatedRegistrations) {

            RegisteredPlayerResponse registeredPlayerResponse = new RegisteredPlayerResponse();
            PlayerResponse playerResponse = new PlayerResponse();

            Player player = playerService.getPlayerByPlayerId(updatedRegistration.getPlayerId());
            playerResponse.setId(player.getId());
            playerResponse.setFirstName(player.getFirstname());
            playerResponse.setLastName(player.getLastname());
            playerResponse.setGender(player.getGender());
            playerResponse.setLevel(updatedRegistration.getPlayerTournamentLevel());

            registeredPlayerResponse.setId(updatedRegistration.getId());
            registeredPlayerResponse.setPaid(updatedRegistration.isPaid());
            registeredPlayerResponse.setPlayer(playerResponse);

            registrationResponse.getRegisteredPlayerList().add(registeredPlayerResponse);

        }   

        return registrationResponse;
        
    }
    
}
