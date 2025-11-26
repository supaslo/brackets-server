package com.wilzsoft.brackets.brackets_server.domain.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TournamentInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String name;

    private Date date;

    private String type;

    private String venue;

    private String city;

    private String state;

    private String photo;
    
}
