package com.wilzsoft.brackets.brackets_server.model.request;

import lombok.Data;

@Data
public class RegisteredPlayerRequest {

    private Integer id;

    private PlayerRequest player;

    private boolean paid;

}
