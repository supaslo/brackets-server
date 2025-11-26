package com.wilzsoft.brackets.brackets_server.model.response;

import lombok.Data;

@Data
public class BracketRoundsResponse {

    private Integer id;

    private Integer bracketId;

    private Integer roundId;

    private String roundCreated;

}
