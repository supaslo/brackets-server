package com.wilzsoft.brackets.brackets_server.model.response;

import lombok.Data;

@Data
public class PlayerResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String gender;
    
    private String level;
    
}
