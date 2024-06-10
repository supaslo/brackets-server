package com.overboardsb.brackets.model.response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class BracketResponse {

    private Integer id;

    private String bracketName;

    private ArrayList<RoundResponse> rounds;

}
