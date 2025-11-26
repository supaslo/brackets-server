package com.wilzsoft.brackets.brackets_server.model.request;

import lombok.Data;

@Data
public class PlayerRequest {

    private Integer id;

    private String firstName;

    private String lastName;

    private String gender;
    
    private String level;

}
