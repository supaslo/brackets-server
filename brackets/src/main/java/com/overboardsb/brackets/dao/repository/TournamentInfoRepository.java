package com.overboardsb.brackets.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.overboardsb.brackets.domain.entity.TournamentInfo;

public interface TournamentInfoRepository  extends CrudRepository<TournamentInfo, Integer> {

    List<TournamentInfo> findAllByOrderByDateDesc();

    List<TournamentInfo> findByIdNotIn(List<Integer> tournamentIds);

    
    
}
