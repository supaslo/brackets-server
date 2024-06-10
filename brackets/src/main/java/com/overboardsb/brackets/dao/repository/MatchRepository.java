package com.overboardsb.brackets.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overboardsb.brackets.domain.entity.Matches;

public interface MatchRepository extends JpaRepository<Matches, Integer>{

}
