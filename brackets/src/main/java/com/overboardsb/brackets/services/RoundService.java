package com.overboardsb.brackets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.RoundRepository;
import com.overboardsb.brackets.domain.entity.Round;
import com.overboardsb.brackets.model.RoundRequest;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    public List<Round> getRoundByBracketId(Integer bracketId) {
        
        List<Round> roundList = roundRepository.findByBracketId(bracketId);
        return roundList;

    }

    public void createRound(RoundRequest round) {

        Round newRound = new Round();

        newRound.setBracketId(round.getBracketId());
        newRound.setSequenceId(round.getSequenceId());
        newRound.setTeamId(round.getTeamId());
        newRound.setFinalRound(round.isFinalRound());

        roundRepository.save(newRound);
    }
}
