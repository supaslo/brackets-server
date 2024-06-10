package com.overboardsb.brackets.dao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overboardsb.brackets.domain.entity.MatchTeams;

@Repository
public interface MatchTeamsRepository extends JpaRepository<MatchTeams, Integer> {

    ArrayList<MatchTeams> findByMatchId(Integer matchId);

}
