package com.ubs.opsit.interviews.clocks;

public class ClockLamp {

    private static final String SWITCHED_OFF_LAMP_STRING_REPRESENTATION = "O";

    private final Color color;
    private final State state;

    public ClockLamp(Color color, State state) {
        if (color == null) {
            throw new IllegalArgumentException("lamp color can not be null");
        }
        if (state == null) {
            throw new IllegalArgumentException("lamp state can not be null");
        }
        this.color = color;
        this.state = state;
    }

    public Color getColor() {
        return color;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        if (State.SWITCHED_ON == state) {
            return color.stringRepresentation;
        } else if (State.SWITCHED_OFF == state) {
            return SWITCHED_OFF_LAMP_STRING_REPRESENTATION;
        } else {
            throw new RuntimeException(String.format("Unknown lamp state=%s", state));
        }
    }

    public enum Color {
        YELLOW("Y"), RED("R");

        private final String stringRepresentation;

        Color(String stringRepresentation) {
            this.stringRepresentation = stringRepresentation;
        }

    }

    public enum State {
        SWITCHED_ON, SWITCHED_OFF
    }

}