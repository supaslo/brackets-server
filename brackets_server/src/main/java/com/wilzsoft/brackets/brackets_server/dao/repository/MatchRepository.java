package com.wilzsoft.brackets.brackets_server.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilzsoft.brackets.brackets_server.domain.entity.Matches;

public interface MatchRepository extends JpaRepository<Matches, Integer>{

}
