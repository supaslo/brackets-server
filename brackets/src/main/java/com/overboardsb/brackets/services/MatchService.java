package com.overboardsb.brackets.services;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.MatchRepository;
import com.overboardsb.brackets.dao.repository.MatchTeamsRepository;
import com.overboardsb.brackets.domain.entity.Matches;
import com.overboardsb.brackets.domain.entity.MatchTeams;
import com.overboardsb.brackets.domain.entity.Team;
import com.overboardsb.brackets.model.request.MatchRequest;
import com.overboardsb.brackets.model.response.MatchResponse;
import com.overboardsb.brackets.model.response.TeamResponse;

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
