package com.ubs.opsit.interviews.model;

public enum Color {

    RED("R"),
    YELLOW("Y");

    private String colorChar;

    Color(String colorChar) {
        this.colorChar = colorChar;
    }

    @Override
    public String toString() {
        return colorChar;
    }

}
