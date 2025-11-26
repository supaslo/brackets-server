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
public class UserInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private Integer id;

    private String userId;

    private String firstName;

    private String lastName;

    private String role;

    private Date createdDate;

    private Date updatedDate;

}
