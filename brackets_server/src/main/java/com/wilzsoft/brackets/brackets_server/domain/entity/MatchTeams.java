package com.wilzsoft.brackets.brackets_server.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MatchTeams {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer matchId;

    private Integer teamId;

}
