package com.overboardsb.brackets.model.response;

import lombok.Data;

@Data
public class RegisteredPlayerResponse {

    private Integer id;

    private boolean paid;

    private PlayerResponse player;
    
}
