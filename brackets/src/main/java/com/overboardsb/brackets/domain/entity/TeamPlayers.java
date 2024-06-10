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
public class TeamPlayers {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private Integer teamId;

    private Integer playerOneId;

    private Integer playerTwoId;

    private Integer playerThreeId;

    private Integer playerFourId;

    private Integer playerFiveId;

    private String teamCreated;
    
}
