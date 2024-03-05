package com.overboardsb.brackets.model;

public class Round {

    private int id;
    private boolean finalRound;
    private Match[] matches;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean getFinalRound() {
        return finalRound;
    }
    public void setFinalRound(boolean finalRound) {
        this.finalRound = finalRound;
    }
    public Match[] getMatches() {
        return matches;
    }
    public void setMatches(Match[] matches) {
        this.matches = matches;
    }    
}
