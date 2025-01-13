package com.overboardsb.brackets.model.request;

import lombok.Data;

@Data
public class RegisteredPlayerRequest {

    private Integer id;

    private PlayerRequest player;

    private boolean paid;

}
