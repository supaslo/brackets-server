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
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String firstname;

    private String lastname;

    private String gender;

    private String level;

}
