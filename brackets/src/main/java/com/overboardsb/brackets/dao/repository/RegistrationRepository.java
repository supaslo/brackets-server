package com.overboardsb.brackets.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.overboardsb.brackets.domain.entity.Registration;
import java.util.List;


public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    List<Registration> findAllByTournamentId(Integer tournamentId);

    @Query("SELECT COUNT(r) FROM Registration r WHERE r.tournamentId = ?1 and r.paid = false")  
    Integer countNonPaidRegistrations(Integer tournamentId);

    Integer countByTournamentId(Integer tournamentId);
}
