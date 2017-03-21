package com.ubs.opsit.interviews;


import java.util.Arrays;

public class BerlinClock {

    public static final char YELLOW = 'Y';
    public static final char RED = 'R';
    public static final char EMTY = 'O';

    private final char[] topLamp;
    private final char[] fiveHoursRow;
    private final char[] oneHourRow;
    private final char[] fiveMinutesRow;
    private final char[] oneMinuteRow;

    public BerlinClock() {
        topLamp = new char[1];
        fiveHoursRow = new char[4];
        oneHourRow = new char[4];
        fiveMinutesRow = new char[11];
        oneMinuteRow = new char[4];
        Arrays.fill(topLamp, EMTY);
        Arrays.fill(fiveHoursRow, EMTY);
        Arrays.fill(oneHourRow, EMTY);
        Arrays.fill(fiveMinutesRow, EMTY);
        Arrays.fill(oneMinuteRow, EMTY);
    }

    public void setTime(int hours, int minutes, int seconds) {
        if (seconds % 2 == 0) {
            topLamp[0] = YELLOW;
        }
        int countLampsFiveHourRow = hours / 5;
        for (int i = 0; i < countLampsFiveHourRow; i++) {
            fiveHoursRow[i] = RED;
        }
        int countLampsOneHourRow = hours % 5;
        for (int i = 0; i < countLampsOneHourRow; i++) {
            oneHourRow[i] = RED;
        }
        int countLampsFiveMinutesRow = minutes / 5;
        for (int i = 0; i < countLampsFiveMinutesRow; i++) {
            if (i % 3 > 1) {
                fiveMinutesRow[i] = RED;
            } else {
                fiveMinutesRow[i] = YELLOW;
            }
        }
        int countLampsOneMinutesRow = minutes % 5;
        for (int i = 0; i < countLampsOneMinutesRow; i++) {
            oneMinuteRow[i] = YELLOW;
        }

    }

    public String buildClock() {
        StringBuilder result = new StringBuilder();
        result.append(topLamp);
        result.append(System.getProperty("line.separator"));
        result.append(fiveHoursRow);
        result.append(System.getProperty("line.separator"));
        result.append(oneHourRow);
        result.append(System.getProperty("line.separator"));
        result.append(fiveMinutesRow);
        result.append(System.getProperty("line.separator"));
        result.append(oneMinuteRow);
        return result.toString();
    }
}

