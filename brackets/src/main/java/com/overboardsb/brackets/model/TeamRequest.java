package com.overboardsb.brackets.model;

import lombok.Data;

@Data
public class TeamRequest {
    
    private Integer matchId;
    
    private String name;

    private Integer firstPlayer;

    private Integer secondPlayer;

    private Integer thirdPlayer;

    private Integer fourthPlayer;

    private Integer fifthPlayer;
    
}
