package com.overboardsb.brackets.model.request;

import java.util.List;
import lombok.Data;

@Data
public class RegistrationRequest {

    private List<RegisteredPlayerRequest> registeredPlayerList;
    
    private Integer tournamentId;
    
}
