package com.overboardsb.brackets.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.overboardsb.brackets.domain.entity.Bracket;

public interface BracketRepository extends CrudRepository<Bracket, Integer> {

}
