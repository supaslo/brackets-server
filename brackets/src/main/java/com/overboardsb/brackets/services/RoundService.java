package com.overboardsb.brackets.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.RoundMatchesRepository;
import com.overboardsb.brackets.dao.repository.RoundRepository;
import com.overboardsb.brackets.domain.entity.Round;
import com.overboardsb.brackets.domain.entity.RoundMatches;
import com.overboardsb.brackets.model.request.RoundRequest;
import com.overboardsb.brackets.model.response.MatchResponse;
import com.overboardsb.brackets.model.response.RoundResponse;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private RoundMatchesRepository roundMatchesRepository;

    @Autowired
    private MatchService matchService;

    public RoundResponse getRoundByRoundId(Integer roundId) {

        RoundResponse roundResponse = new RoundResponse();

        Round round = new Round();
        Optional<Round> dbRound = roundRepository.findById(roundId);
        if (dbRound.isPresent()) {
            round = dbRound.get();
        }
        roundResponse.setId(round.getDisplayId());
        roundResponse.setFinalRound(round.getFinalRound());

        ArrayList<RoundMatches> roundMatchesList = roundMatchesRepository.findByRoundId(roundId); 

        ArrayList<MatchResponse> matchResponses = new ArrayList<>();
        for (RoundMatches roundMatches : roundMatchesList) {
            MatchResponse matchResponse = matchService.getMatchByMatchId(roundMatches.getMatchId());
            matchResponses.add(matchResponse);
        }

        roundResponse.setMatches(matchResponses);

        return roundResponse;
    }

    public void createRound(RoundRequest round) {

        Round newRound = new Round();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        newRound.setDisplayId(round.getDisplayId());
        newRound.setFinalRound(round.isFinalRound());
        newRound.setRoundCreated(dateFormat.format(date));

        roundRepository.save(newRound);
    }

}
