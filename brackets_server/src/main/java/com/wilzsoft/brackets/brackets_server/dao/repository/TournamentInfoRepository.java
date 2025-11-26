package com.wilzsoft.brackets.brackets_server.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wilzsoft.brackets.brackets_server.domain.entity.TournamentInfo;

public interface TournamentInfoRepository  extends CrudRepository<TournamentInfo, Integer> {

    List<TournamentInfo> findAllByOrderByDateDesc();

    List<TournamentInfo> findByIdNotIn(List<Integer> tournamentIds);

    
    
}
