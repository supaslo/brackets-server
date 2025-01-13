package com.overboardsb.brackets.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TournamentPlayer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer tournamentId;

    private Integer playerId;

    private String playerLevel;
    
}
