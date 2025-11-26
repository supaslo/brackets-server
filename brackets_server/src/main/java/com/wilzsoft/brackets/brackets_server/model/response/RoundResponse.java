package com.wilzsoft.brackets.brackets_server.model.response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RoundResponse implements Comparable<RoundResponse> {

    private Integer id;

    private Boolean finalRound;

    private ArrayList<MatchResponse> matches;

    @Override
    public int compareTo(RoundResponse compareRound) {
        int compareage=((RoundResponse)compareRound).getId();
        /* For Ascending order*/
        return this.id-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }

}