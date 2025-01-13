package com.overboardsb.brackets.model.request;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class TournamentRequest {

    private Integer id;

    private String name;
    
    private Date date;

    private String type;

    private String venue;

    private String city;

    private String state;

    private String photo;

}
