package com.overboardsb.brackets.dao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overboardsb.brackets.domain.entity.BracketRounds;

@Repository 
public interface BracketRoundsRepository extends JpaRepository<BracketRounds, Integer> {

    ArrayList<BracketRounds> findByBracketId(Integer bracketId);

}
