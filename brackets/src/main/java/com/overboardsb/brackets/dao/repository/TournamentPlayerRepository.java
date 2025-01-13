package com.overboardsb.brackets.dao.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.overboardsb.brackets.domain.entity.TournamentPlayer;

public interface TournamentPlayerRepository extends CrudRepository<TournamentPlayer, Integer> {

    ArrayList<TournamentPlayer> findPlayersByTournamentIdAndPlayerLevel(Integer tournamentId, String playerLevel);
    
}
