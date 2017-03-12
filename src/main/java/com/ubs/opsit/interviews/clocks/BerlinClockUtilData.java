package com.ubs.opsit.interviews.clocks;

public class BerlinClockUtilData {

    private final int secondsMod2;
    private final int hoursDiv5;
    private final int hoursMod5;
    private final int minutesDiv5;
    private final int minutesMod5;

    public BerlinClockUtilData(int hours, int minutes, int seconds) {
        this.secondsMod2 = seconds % 2;
        this.hoursDiv5 = hours / 5;
        this.hoursMod5 = hours % 5;
        this.minutesDiv5 = minutes / 5;
        this.minutesMod5 = minutes % 5;
    }

    @Override
    public String toString() {
        return "BerlinClockUtilData{" +
                "secondsMod2=" + secondsMod2 +
                ", hoursDiv5=" + hoursDiv5 +
                ", hoursMod5=" + hoursMod5 +
                ", minutesDiv5=" + minutesDiv5 +
                ", minutesMod5=" + minutesMod5 +
                '}';
    }

    public int getSecondsMod2() {
        return secondsMod2;
    }

    public int getHoursDiv5() {
        return hoursDiv5;
    }

    public int getHoursMod5() {
        return hoursMod5;
    }

    public int getMinutesDiv5() {
        return minutesDiv5;
    }

    public int getMinutesMod5() {
        return minutesMod5;
    }
}