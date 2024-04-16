package com.overboardsb.brackets.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overboardsb.brackets.domain.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    
}
