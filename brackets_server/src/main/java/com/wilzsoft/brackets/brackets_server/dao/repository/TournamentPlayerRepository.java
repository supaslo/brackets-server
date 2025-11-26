package com.wilzsoft.brackets.brackets_server.dao.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.wilzsoft.brackets.brackets_server.domain.entity.TournamentPlayer;

public interface TournamentPlayerRepository extends CrudRepository<TournamentPlayer, Integer> {

    ArrayList<TournamentPlayer> findPlayersByTournamentIdAndPlayerLevel(Integer tournamentId, String playerLevel);
    
}
