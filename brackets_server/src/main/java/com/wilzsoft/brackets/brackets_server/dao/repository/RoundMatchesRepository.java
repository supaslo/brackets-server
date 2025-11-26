package com.wilzsoft.brackets.brackets_server.dao.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wilzsoft.brackets.brackets_server.domain.entity.RoundMatches;

@Repository
public interface RoundMatchesRepository extends JpaRepository<RoundMatches, Integer> {

    ArrayList<RoundMatches> findByRoundId(Integer roundId);

}
