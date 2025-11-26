package com.wilzsoft.brackets.brackets_server.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilzsoft.brackets.brackets_server.dao.repository.RoundMatchesRepository;
import com.wilzsoft.brackets.brackets_server.domain.entity.RoundMatches;
import com.wilzsoft.brackets.brackets_server.model.request.RoundMatchesRequest;

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
