package com.overboardsb.brackets.model.request;

import lombok.Data;

@Data
public class RoundMatchesRequest {

    private Integer bracketId;

    private Integer matchId;

    private Integer roundId;

}
