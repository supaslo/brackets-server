package com.overboardsb.brackets.model.response;

import java.util.List;

import lombok.Data;

@Data
public class RegistrationResponse {

    private TournamentResponse tournamentRegistered;

    private Integer playerCount;

    private boolean everybodyPaid;

    private List<RegisteredPlayerResponse> registeredPlayerList;
        
}