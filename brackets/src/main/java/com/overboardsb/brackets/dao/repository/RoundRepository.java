package com.overboardsb.brackets.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overboardsb.brackets.domain.entity.Round;
import java.util.ArrayList;


@Repository
public interface RoundRepository extends JpaRepository<Round, Integer> {

    ArrayList<Round> findByIdOrderByDisplayId(Integer roundId);

}
