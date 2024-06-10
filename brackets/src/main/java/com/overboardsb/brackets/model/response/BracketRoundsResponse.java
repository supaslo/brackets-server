package com.overboardsb.brackets.model.response;

import lombok.Data;

@Data
public class BracketRoundsResponse {

    private Integer id;

    private Integer bracketId;

    private Integer roundId;

    private String roundCreated;

}
