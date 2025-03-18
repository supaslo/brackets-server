package com.overboardsb.brackets.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.TournamentInfoRepository;
import com.overboardsb.brackets.domain.entity.TournamentInfo;
import com.overboardsb.brackets.model.request.TournamentRequest;
import com.overboardsb.brackets.model.response.TournamentResponse;

@Service
public class TournamentService {

    @Autowired
    private TournamentInfoRepository tournamentInfoRepository;

    public String deleteTournament(Integer tournamentId) {

        tournamentInfoRepository.deleteById(tournamentId);
        return("Successful Delete");
    }

    public ArrayList<TournamentResponse> getTournaments() {
        
        ArrayList<TournamentResponse> tournamentResponses = new ArrayList<>();
        Iterable<TournamentInfo> tournaments = new ArrayList<>();

        tournaments = tournamentInfoRepository.findAllByOrderByDateDesc();
        for(TournamentInfo tournament : tournaments) {
            TournamentResponse tournamentResponse = new TournamentResponse();
            tournamentResponse.setId(tournament.getId());
            tournamentResponse.setName(tournament.getName());
            tournamentResponse.setDate(tournament.getDate());
            tournamentResponse.setType(tournament.getType());
            tournamentResponse.setVenue(tournament.getVenue());
            tournamentResponse.setCity(tournament.getCity());
            tournamentResponse.setState(tournament.getState());
            tournamentResponse.setPhoto(tournament.getPhoto());

            /*Iterable<TournamentPlayer> tournamentAPlayers = new ArrayList<>();
            Iterable<TournamentPlayer> tournamentBPlayers = new ArrayList<>();
            tournamentAPlayers = tournamentPlayerRepository.findPlayersByTournamentIdAndPlayerLevel(tournament.getId(), "1");
            tournamentBPlayers = tournamentPlayerRepository.findPlayersByTournamentIdAndPlayerLevel(tournament.getId(), "2");
            ArrayList<String> aPlayers = new ArrayList<>();
            ArrayList<String> bPlayers = new ArrayList<>();

            //Get A Player names for this tournament
            for(TournamentPlayer tournamentPlayer : tournamentAPlayers) {
                Optional<Player> dbPlayer = playerRepository.findById(tournamentPlayer.getId());

                Player player = new Player();
                if (dbPlayer.isPresent()) {
                    player = dbPlayer.get();
                }
                aPlayers.add(player.getFirstname());
            }
            tournamentResponse.setAplayerlist(aPlayers);
            
            //Get B Player names for this tournament
            for(TournamentPlayer tournamentPlayer : tournamentBPlayers) {
                Optional<Player> dbPlayer = playerRepository.findById(tournamentPlayer.getId());

                Player player = new Player();
                if (dbPlayer.isPresent()) {
                    player = dbPlayer.get();
                }
                bPlayers.add(player.getFirstname());
            }
            tournamentResponse.setBplayerlist(bPlayers);*/

            tournamentResponses.add(tournamentResponse);
        }

        return tournamentResponses;

    }

    public ArrayList<TournamentResponse> getTournaments(List<Integer> tournamentIds) {
        
        ArrayList<TournamentResponse> tournamentResponses = new ArrayList<>();
        Iterable<TournamentInfo> tournaments = new ArrayList<>();

        tournaments = tournamentInfoRepository.findByIdNotIn(tournamentIds);
        for(TournamentInfo tournament : tournaments) {
            TournamentResponse tournamentResponse = new TournamentResponse();
            tournamentResponse.setId(tournament.getId());
            tournamentResponse.setName(tournament.getName());
            tournamentResponse.setDate(tournament.getDate());
            tournamentResponse.setType(tournament.getType());
            tournamentResponse.setVenue(tournament.getVenue());
            tournamentResponse.setCity(tournament.getCity());
            tournamentResponse.setState(tournament.getState());
            tournamentResponse.setPhoto(tournament.getPhoto());

            tournamentResponses.add(tournamentResponse);
        }

        return tournamentResponses;

    }

    public TournamentResponse getTournamentByTournamentId(Integer tournamentId) {

        TournamentInfo tournament = new TournamentInfo();
        Optional<TournamentInfo> dbTournament = tournamentInfoRepository.findById(tournamentId);
        if (dbTournament.isPresent()) {
            tournament = dbTournament.get();
        }
        TournamentResponse tournamentResponse = new TournamentResponse();
        tournamentResponse.setId(tournament.getId());
        tournamentResponse.setName(tournament.getName());
        tournamentResponse.setDate(tournament.getDate());
        tournamentResponse.setType(tournament.getType());
        tournamentResponse.setVenue(tournament.getVenue());
        tournamentResponse.setCity(tournament.getCity());
        tournamentResponse.setState(tournament.getState());
        tournamentResponse.setPhoto(tournament.getPhoto());

        /*Iterable<TournamentPlayer> tournamentAPlayers = new ArrayList<>();
        Iterable<TournamentPlayer> tournamentBPlayers = new ArrayList<>();
        tournamentAPlayers = tournamentPlayerRepository.findPlayersByTournamentIdAndPlayerLevel(tournament.getId(), "1");
        tournamentBPlayers = tournamentPlayerRepository.findPlayersByTournamentIdAndPlayerLevel(tournament.getId(), "2");
        ArrayList<String> aPlayers = new ArrayList<>();
        ArrayList<String> bPlayers = new ArrayList<>();

        //Get A Player names for this tournament
        for(TournamentPlayer tournamentPlayer : tournamentAPlayers) {
            Optional<Player> dbPlayer = playerRepository.findById(tournamentPlayer.getId());

            Player player = new Player();
            if (dbPlayer.isPresent()) {
                player = dbPlayer.get();
            }
            aPlayers.add(player.getFirstname());
        }
        tournamentResponse.setAplayerlist(aPlayers);*/
            
        //Get B Player names for this tournament
        /*for(TournamentPlayer tournamentPlayer : tournamentBPlayers) {
            Optional<Player> dbPlayer = playerRepository.findById(tournamentPlayer.getId());

            Player player = new Player();
            if (dbPlayer.isPresent()) {
                player = dbPlayer.get();
            }
            bPlayers.add(player.getFirstname());
        }
        tournamentResponse.setBplayerlist(bPlayers);*/

        return tournamentResponse;

    }

    public TournamentResponse createTournament(TournamentRequest tournament) {

        TournamentInfo newTournament = new TournamentInfo();

        newTournament.setName(tournament.getName());
        newTournament.setDate(tournament.getDate());
        newTournament.setType(tournament.getType());
        newTournament.setVenue(tournament.getVenue());
        newTournament.setCity(tournament.getCity());
        newTournament.setState(tournament.getState());
        newTournament.setPhoto(tournament.getPhoto());

        TournamentInfo savedTournamentInfo = new TournamentInfo();
        TournamentResponse newTournamentResponse = new TournamentResponse();

        savedTournamentInfo = tournamentInfoRepository.save(newTournament);

        newTournamentResponse.setName(savedTournamentInfo.getName());
        newTournamentResponse.setVenue(savedTournamentInfo.getVenue());
        newTournamentResponse.setType(savedTournamentInfo.getType());
        newTournamentResponse.setDate(tournament.getDate());
        newTournamentResponse.setCity(savedTournamentInfo.getCity());
        newTournamentResponse.setState(savedTournamentInfo.getState());
        newTournamentResponse.setPhoto(savedTournamentInfo.getPhoto());

        return newTournamentResponse;

    }

    public TournamentResponse updateTournament(TournamentRequest tournament) {

        TournamentInfo modifiedTournament = new TournamentInfo();

        modifiedTournament.setId(tournament.getId());
        modifiedTournament.setName(tournament.getName());
        modifiedTournament.setDate(tournament.getDate());
        modifiedTournament.setType(tournament.getType());
        modifiedTournament.setVenue(tournament.getVenue());
        modifiedTournament.setCity(tournament.getCity());
        modifiedTournament.setState(tournament.getState());
        modifiedTournament.setPhoto(tournament.getPhoto());

        TournamentInfo savedTournamentInfo = new TournamentInfo();
        TournamentResponse newTournamentResponse = new TournamentResponse();

        savedTournamentInfo = tournamentInfoRepository.save(modifiedTournament);

        newTournamentResponse.setName(savedTournamentInfo.getName());
        newTournamentResponse.setVenue(savedTournamentInfo.getVenue());
        newTournamentResponse.setType(savedTournamentInfo.getType());
        newTournamentResponse.setDate(tournament.getDate());
        newTournamentResponse.setCity(savedTournamentInfo.getCity());
        newTournamentResponse.setState(savedTournamentInfo.getState());
        newTournamentResponse.setPhoto(savedTournamentInfo.getPhoto());

        return newTournamentResponse;

    }
    
}
