package com.overboardsb.brackets.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.RoundMatchesRepository;
import com.overboardsb.brackets.domain.entity.RoundMatches;
import com.overboardsb.brackets.model.request.RoundMatchesRequest;

@Service
public class RoundMatchesService {

    /*@Autowired
    private RoundMatchesRepository roundMatchesRepository;

    public List<RoundMatches> getRoundMatchesById(Integer roundId) {

        List<RoundMatches> roundMatchesList = roundMatchesRepository.findByRoundId(roundId);
        return roundMatchesList;

    }

    public void createRoundMatches(RoundMatchesRequest request) {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        RoundMatches roundMatches = new RoundMatches();
        roundMatches.setBracketId(request.getBracketId());
        roundMatches.setRoundId(request.getRoundId());
        roundMatches.setMatchId(request.getMatchId());
        roundMatches.setRoundCreated(dateFormat.format(date));
        roundMatchesRepository.save(roundMatches);
    }*/

}
