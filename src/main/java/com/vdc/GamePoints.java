package com.vdc;

/**
 * Created by Vincent on 09/01/2018.
 */
public enum GamePoints {

    ZERO("0"), FIFTEEN("15"), THIRTEEN("30"), FOURTEEN("40"), ADVANTAGE("A"), GAME("GAME");

    GamePoints(String text) {
        this.text = text;
    }

    private String text;

    public String getText() {
        return text;
    }
}
