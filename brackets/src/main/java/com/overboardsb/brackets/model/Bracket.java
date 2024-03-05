package com.overboardsb.brackets.model;

public class Bracket {

    private int id;
    private String bracketName;
    private Round[] rounds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBracketName() {
        return bracketName;
    }

    public void setBracketName(String bracketName) {
        this.bracketName = bracketName;
    }

    public Round[] getRounds() {
        return rounds;
    }

    public void setRounds(Round[] rounds) {
        this.rounds = rounds;
    }
    
}
