package com.overboardsb.brackets.model.request;

import lombok.Data;

@Data
public class PlayerRequest {

    private Integer id;

    private String firstName;

    private String lastName;

    private String gender;
    
    private String level;

}
