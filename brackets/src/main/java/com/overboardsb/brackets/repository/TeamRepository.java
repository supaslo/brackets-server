package com.overboardsb.brackets.repository;

import org.springframework.data.repository.CrudRepository;

import com.overboardsb.brackets.repository.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    
}
