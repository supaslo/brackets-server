package com.wilzsoft.brackets.brackets_server.model.request;

import lombok.Data;

@Data
public class MatchRequest {

    private Integer sequenceId;

    private Integer homeTeam;

    private Integer awayTeam;

}
