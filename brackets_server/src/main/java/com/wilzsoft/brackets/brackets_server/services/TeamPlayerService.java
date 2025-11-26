package com.wilzsoft.brackets.brackets_server.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilzsoft.brackets.brackets_server.dao.repository.TeamPlayersRepository;
import com.wilzsoft.brackets.brackets_server.domain.entity.TeamPlayers;

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
