package com.overboardsb.brackets.repository;

import org.springframework.data.repository.CrudRepository;

import com.overboardsb.brackets.repository.entity.Teams;

public interface TeamsRepository extends CrudRepository<Teams, Integer> {
    
}
