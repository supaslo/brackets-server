package com.wilzsoft.brackets.brackets_server.services;

import java.util.Optional;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilzsoft.brackets.brackets_server.dao.repository.TeamRepository;
import com.wilzsoft.brackets.brackets_server.domain.entity.Team;
import com.wilzsoft.brackets.brackets_server.domain.entity.TeamPlayers;
import com.wilzsoft.brackets.brackets_server.model.request.TeamRequest;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team getTeamById(Integer teamId) {

        Team team = new Team();
        if (teamId == null) {
            teamId = 0;
            team.setName("");
        }
        Optional<Team> dbTeam = teamRepository.findById(teamId);
        if (dbTeam.isPresent()) {
            team = dbTeam.get();
        }
        return team;

    }

    public List<Team> getAllTeams() {

        List<Team> teams = teamRepository.findAll();
        return teams;
        
    }

    public void createTeam(TeamRequest team) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        Team newTeam = new Team();

        newTeam.setName(team.getName());
        
        Team savedTeam = teamRepository.save(newTeam);

        TeamPlayers teamPlayers = new TeamPlayers();

        teamPlayers.setTeamId(savedTeam.getId());
        teamPlayers.setPlayerOneId(team.getPlayerOne());
        teamPlayers.setPlayerTwoId(team.getPlayerTwo());
        teamPlayers.setPlayerThreeId(team.getPlayerThree());
        teamPlayers.setPlayerFourId(team.getPlayerFour());
        teamPlayers.setPlayerFiveId(team.getPlayerFive());
        teamPlayers.setTeamCreated(dateFormat.format(date));
        
        //teamPlayersRepository.save(teamPlayers);

        /*PlayerTeamHistory playerTeamHistoryOne = new PlayerTeamHistory();
        playerTeamHistoryOne.setTeamId(savedTeam.getId());
        playerTeamHistoryOne.setPlayerId(team.getFirstPlayer());
        playerTeamHistoryOne.setTeamCreated(dateFormat.format(date));
        playerTeamHistoryRepository.save(playerTeamHistoryOne);


        PlayerTeamHistory playerTeamHistoryTwo = new PlayerTeamHistory();
        playerTeamHistoryTwo.setTeamId(savedTeam.getId());
        playerTeamHistoryTwo.setPlayerId(team.getFirstPlayer());
        playerTeamHistoryTwo.setTeamCreated(dateFormat.format(date));
        playerTeamHistoryRepository.save(playerTeamHistoryTwo);

        PlayerTeamHistory playerTeamHistoryThree = new PlayerTeamHistory();
        playerTeamHistoryThree.setTeamId(savedTeam.getId());
        playerTeamHistoryThree.setPlayerId(team.getFirstPlayer());
        playerTeamHistoryThree.setTeamCreated(dateFormat.format(date));
        playerTeamHistoryRepository.save(playerTeamHistoryThree);

        PlayerTeamHistory playerTeamHistoryFour = new PlayerTeamHistory();
        playerTeamHistoryFour.setTeamId(savedTeam.getId());
        playerTeamHistoryFour.setPlayerId(team.getFirstPlayer());
        playerTeamHistoryFour.setTeamCreated(dateFormat.format(date));
        playerTeamHistoryRepository.save(playerTeamHistoryFour);

        PlayerTeamHistory playerTeamHistoryFive = new PlayerTeamHistory();
        playerTeamHistoryFive.setTeamId(savedTeam.getId());
        playerTeamHistoryFive.setPlayerId(team.getFirstPlayer());
        playerTeamHistoryFive.setTeamCreated(dateFormat.format(date));
        playerTeamHistoryRepository.save(playerTeamHistoryFive);*/

    }

}
