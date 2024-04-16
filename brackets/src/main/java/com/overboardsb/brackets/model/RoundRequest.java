package com.overboardsb.brackets.model;

import lombok.Data;

@Data
public class RoundRequest {

    private Integer bracketId;

    private Integer sequenceId;

    private Integer teamId;

    private boolean finalRound;

}
