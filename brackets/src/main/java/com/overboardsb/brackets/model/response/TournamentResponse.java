package com.overboardsb.brackets.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class TournamentResponse {

    private Integer id;

    private String name;
    
    private Date date;

    private String type;

    private String venue;

    private String city;

    private String state;

    private String photo;
    
}
