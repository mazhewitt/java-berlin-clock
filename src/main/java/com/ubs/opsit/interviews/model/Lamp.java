package com.ubs.opsit.interviews.model;


public class Lamp {

    private Color color;
    private boolean on;

    public Lamp(Color color) {
        this.color = color;
        this.on = false;
    }

    @Override
    public String toString() {
        if (this.on) {
            return color.toString();
        } else {
            return "O";
        }
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isOn() {
        return on;
    }
}
