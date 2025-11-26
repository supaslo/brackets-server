package com.wilzsoft.brackets.brackets_server.services;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilzsoft.brackets.brackets_server.dao.repository.MatchRepository;
import com.wilzsoft.brackets.brackets_server.dao.repository.MatchTeamsRepository;
import com.wilzsoft.brackets.brackets_server.domain.entity.Matches;
import com.wilzsoft.brackets.brackets_server.domain.entity.MatchTeams;
import com.wilzsoft.brackets.brackets_server.domain.entity.Team;
import com.wilzsoft.brackets.brackets_server.model.request.MatchRequest;
import com.wilzsoft.brackets.brackets_server.model.response.MatchResponse;
import com.wilzsoft.brackets.brackets_server.model.response.TeamResponse;

@Service
public class MatchService {

    @Autowired
    private TeamService teamService;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchTeamsRepository matchTeamsRepository;

    public MatchResponse getMatchByMatchId(Integer matchId) {

        MatchResponse matchResponse = new MatchResponse();

        Matches match = new Matches();
        Optional<Matches> dbMatch = matchRepository.findById(matchId);
        if (dbMatch.isPresent()) {
            match = dbMatch.get();
            Team homeTeam = teamService.getTeamById(match.getHomeTeam());
            matchResponse.setHome(homeTeam.getName());
            Team awayTeam = teamService.getTeamById(match.getAwayTeam());
            matchResponse.setAway(awayTeam.getName());
        } else {
            matchResponse.setHome("");
            matchResponse.setAway("");
        }

        matchResponse.setId(match.getDisplayId());

        return matchResponse;

    }

    /*public void createMatch(MatchRequest matchRequest) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        MatchTeams matchTeams = new MatchTeams();

        matchTeams.setSequenceId(matchRequest.getSequenceId());
        matchTeams.setHomeTeamId(matchRequest.getHomeTeam());
        matchTeams.setAwayTeamId(matchRequest.getAwayTeam());
        matchTeams.setMatchCreated(dateFormat.format(date));

        matchTeamsRepository.save(matchTeams);

    }*/

}
