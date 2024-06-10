package com.overboardsb.brackets.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overboardsb.brackets.domain.entity.TeamPlayers;

@Repository
public interface TeamPlayersRepository extends JpaRepository<TeamPlayers, Integer> {
    
}
