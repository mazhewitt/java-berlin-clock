package com.ubs.opsit.interviews.model;

public class BerlinClock{

    private Lamp secondsLamp;
    private Row fiveHoursRow;
    private Row oneHourRow;
    private Row fiveMinutesRow;
    private Row oneMinuteRow;

    public BerlinClock() {
        secondsLamp = new Lamp(Color.YELLOW);
        secondsLamp.turnOn();

        fiveHoursRow = new Row(4, Color.RED);
        oneHourRow = new Row(4, Color.RED);
        fiveMinutesRow = new Row(11, Color.YELLOW);
        fiveMinutesRow.changeColor(Color.RED, 3, 6, 9);
        oneMinuteRow = new Row(4, Color.YELLOW);
    }



    public BerlinClock setSeconds(int seconds) {
        if (seconds % 2 == 0) {
            secondsLamp.turnOn();
        } else {
            secondsLamp.turnOff();
        }

        return this;
    }

    public BerlinClock setHours(int hours) {
        int fiveHours = hours / 5;
        int rest = hours % 5;

        fiveHoursRow.turnOn(fiveHours);
        oneHourRow.turnOn(rest);

        return this;
    }

    public BerlinClock setMinutes(int minutes) {
        int fiveMinutes = minutes / 5;
        int rest = minutes % 5;

        fiveMinutesRow.turnOn(fiveMinutes);
        oneMinuteRow.turnOn(rest);

        return this;
    }

    public Lamp getSecondsLamp() {
        return secondsLamp;
    }

    public Row getFiveHoursRow() {
        return fiveHoursRow;
    }

    public Row getOneHourRow() {
        return oneHourRow;
    }

    public Row getFiveMinutesRow() {
        return fiveMinutesRow;
    }

    public Row getOneMinuteRow() {
        return oneMinuteRow;
    }

    @Override
    public String toString() {
        return getSecondsLamp().toString() + "\n"
                + getFiveHoursRow().toString() + "\n"
                + getOneHourRow().toString() + "\n"
                + getFiveMinutesRow().toString() + "\n"
                + getOneMinuteRow().toString();
    }
}
