package com.overboardsb.brackets.model.request;

import lombok.Data;

@Data
public class MatchRequest {

    private Integer sequenceId;

    private Integer homeTeam;

    private Integer awayTeam;

}
