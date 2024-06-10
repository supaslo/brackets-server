package com.overboardsb.brackets.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.TeamPlayersRepository;
import com.overboardsb.brackets.domain.entity.TeamPlayers;

@Service
public class TeamPlayerService {

    @Autowired
    private TeamPlayersRepository teamPlayersRepository;

    public Integer getTeamPlayersById(Integer teamId) {

        TeamPlayers teamPlayers = new TeamPlayers();
        Optional<TeamPlayers> dbTeamPlayers = teamPlayersRepository.findById(teamId);
        if (dbTeamPlayers.isPresent()) {
            teamPlayers = dbTeamPlayers.get();
        }
        return teamPlayers.getTeamId();

    }

}
