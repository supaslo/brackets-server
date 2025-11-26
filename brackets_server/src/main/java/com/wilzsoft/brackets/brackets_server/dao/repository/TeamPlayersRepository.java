package com.wilzsoft.brackets.brackets_server.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wilzsoft.brackets.brackets_server.domain.entity.TeamPlayers;

@Repository
public interface TeamPlayersRepository extends JpaRepository<TeamPlayers, Integer> {
    
}
