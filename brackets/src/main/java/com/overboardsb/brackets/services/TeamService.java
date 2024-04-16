package com.overboardsb.brackets.services;

import java.util.Date;
import java.util.Optional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.PlayerTeamHistoryRepository;
import com.overboardsb.brackets.dao.repository.TeamRepository;
import com.overboardsb.brackets.domain.entity.PlayerTeamHistory;
import com.overboardsb.brackets.domain.entity.Team;
import com.overboardsb.brackets.model.TeamRequest;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerTeamHistoryRepository playerTeamHistoryRepository;

    public Team getTeamById(Integer teamId) {

        Team team = new Team();
        Optional<Team> dbTeam = teamRepository.findById(teamId);
        if (dbTeam.isPresent()) {
            team = dbTeam.get();
        }
        return team;

    }

    public void createTeam(TeamRequest team) {

        Team newTeam = new Team();

        newTeam.setName(team.getName());
        newTeam.setPlayerOne(team.getFirstPlayer());
        newTeam.setPlayerTwo(team.getSecondPlayer());
        newTeam.setPlayerThree(team.getThirdPlayer());
        newTeam.setPlayerFour(team.getFourthPlayer());
        newTeam.setPlayerFive(team.getFifthPlayer());
        
        Team savedTeam = teamRepository.save(newTeam);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        PlayerTeamHistory playerTeamHistoryOne = new PlayerTeamHistory();
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
        playerTeamHistoryRepository.save(playerTeamHistoryFive);


        

    }

}
