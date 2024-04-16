package com.overboardsb.brackets.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overboardsb.brackets.dao.repository.BracketRepository;
import com.overboardsb.brackets.domain.entity.Bracket;

@Service
public class BracketService {

    @Autowired
	private BracketRepository bracketsRepository;

    public Bracket getAllBrackets(Integer bracketId) {

        Bracket bracket = new Bracket();
        Optional<Bracket> dbBracket = bracketsRepository.findById(bracketId);
        if (dbBracket.isPresent()) {
            bracket = dbBracket.get();
        }

        /*String bracketName = brackets;
        
        System.out.println("test bracket: " + bracketName);*/

        //Bracket bracket = new Bracket();
        /*Round[] rounds = new Round[4];
        Match[] matches1 = new Match[4];
        Match[] matches2 = new Match[2];
        Match[] matches3 = new Match[1];
        Match[] matches4 = new Match[1];

        Match match1 = new Match();
        match1.setId(1);
        match1.setHome("Fireballz");
        match1.setAway("Bangin the Neighbors");
        matches1[0] = match1;

        Match match2 = new Match();
        match2.setId(2);
        match2.setHome("Your Other");
        match2.setAway("Wrong Hole");
        matches1[1] = match2;

        Match match3 = new Match();
        match3.setId(3);
        match3.setHome("Pervs");
        match3.setAway("The Statler's");
        matches1[2] = match3;

        Match match4 = new Match();
        match4.setId(4);
        match4.setHome("Middle Aged Whores");
        match4.setAway("Don't Care");
        matches1[3] = match4;

        Round round1 = new Round();
        round1.setId(1);
        round1.setFinalRound(false);
        round1.setMatches(matches1);
        rounds[0] = round1;

        Match match5 = new Match();
        match5.setId(5);
        match5.setHome("");
        match5.setAway("");
        matches2[0] = match5;

        Match match6 = new Match();
        match6.setId(6);
        match6.setHome("");
        match6.setAway("");
        matches2[1] = match6;

        Round round2 = new Round();
        round2.setId(2);
        round2.setFinalRound(false);
        round2.setMatches(matches2);
        rounds[1] = round2;

        Match match7 = new Match();
        match7.setId(7);
        match7.setHome("");
        match7.setAway("");
        matches3[0] = match7;

        Round round3 = new Round();
        round3.setId(3);
        round3.setFinalRound(false);
        round3.setMatches(matches3);
        rounds[2] = round3;       

        Match match8 = new Match();
        match8.setId(8);
        match8.setHome("");
        match8.setAway("");
        matches4[0] = match8;

        Round round4 = new Round();
        round4.setId(4);
        round4.setFinalRound(true);
        round4.setMatches(matches4);
        rounds[3] = round4;

        bracket.setId(1);
        bracket.setBracketName("Wicked Rabbit Friday Tournament 2/26/2024");
        bracket.setRounds(rounds);*/

        return bracket;
    }
    
}
