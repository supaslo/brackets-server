package com.wilzsoft.brackets.brackets_server.model.response;

import lombok.Data;

@Data
public class TeamResponse {

    private Integer teamId;

    private String name;

    private String playerOne;
    
    private String playerTwo;

    private String playerThree;

    private String playerFour;

    private String playerFive;

}
