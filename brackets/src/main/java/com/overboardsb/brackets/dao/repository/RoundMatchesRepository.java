package com.overboardsb.brackets.dao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overboardsb.brackets.domain.entity.RoundMatches;

@Repository
public interface RoundMatchesRepository extends JpaRepository<RoundMatches, Integer> {

    ArrayList<RoundMatches> findByRoundId(Integer roundId);

}
