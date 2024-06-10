package com.overboardsb.brackets.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.BracketRepository;
import com.overboardsb.brackets.dao.repository.BracketRoundsRepository;
import com.overboardsb.brackets.domain.entity.Bracket;
import com.overboardsb.brackets.domain.entity.BracketRounds;
import com.overboardsb.brackets.model.response.BracketResponse;
import com.overboardsb.brackets.model.response.RoundResponse;

@Service
public class BracketService {

    @Autowired
	private BracketRepository bracketRepository;

    @Autowired
	private BracketRoundsRepository bracketRoundsRepository;

    @Autowired
    private RoundService roundService;

    public BracketResponse getBracketById(Integer bracketId) {

        BracketResponse bracketResponse = new BracketResponse();

        Bracket bracket = new Bracket();
        Optional<Bracket> dbBracket = bracketRepository.findById(bracketId);
        if (dbBracket.isPresent()) {
            bracket = dbBracket.get();
        }
        bracketResponse.setId(bracket.getId());
        bracketResponse.setBracketName(bracket.getName());

        ArrayList<BracketRounds> bracketRoundsList = bracketRoundsRepository.findByBracketId(bracketId);

        ArrayList<RoundResponse> roundResponses = new ArrayList<>();
        for (BracketRounds bracketRound : bracketRoundsList) {
            RoundResponse roundResponse = roundService.getRoundByRoundId(bracketRound.getRoundId());
            roundResponses.add(roundResponse);
        };

        Collections.sort(roundResponses);

        bracketResponse.setRounds(roundResponses);

        return bracketResponse;
    }

    /*public void createBracketRounds(BracketRoundsRequest request) {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        BracketRounds bracketRounds = new BracketRounds();
        bracketRounds.setBracketId(request.getBracketId());
        bracketRounds.setRoundId(request.getRoundId());        bracketRounds.setBracketCreated(dateFormat.format(date));
        bracketRoundsRepository.save(bracketRounds);
    }*/
    
}
