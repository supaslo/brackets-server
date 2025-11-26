package com.wilzsoft.brackets.brackets_server.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.wilzsoft.brackets.brackets_server.domain.entity.Bracket;

public interface BracketRepository extends CrudRepository<Bracket, Integer> {

}
