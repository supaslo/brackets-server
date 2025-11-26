package com.wilzsoft.brackets.brackets_server.model.response;

import lombok.Data;

@Data
public class RegisteredPlayerResponse {

    private Integer id;

    private boolean paid;

    private PlayerResponse player;
    
}
