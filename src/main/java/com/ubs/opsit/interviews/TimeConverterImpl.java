package com.ubs.opsit.interviews;

import java.util.Arrays;

/**
 * Implementation of Berlin Clock time converter.
 * Example of usage:
 * new TimeConverterImpl().convertTime("13:17:01")
 */
public class TimeConverterImpl implements TimeConverter {

    public static final String SECOND_BLINK = "Y";
    public static final char OFF = 'O';

    public static final String HOURS_TEMPLATE = "RRRR";
    public static final String MINUTES_TOP_ROW_TEMPLATE = "YYRYYRYYRYY";
    public static final String MINUTES_BOTTOM_ROW_TEMPLATE = "YYYY";

    /**
     * Converts time from HH-MM-SS format into Berlin Clock format
     *
     * @param aTime time in format HH-MM-SS
     * @return Berlin Clock format
     */
    @Override
    public String convertTime(String aTime) {
        final int[] time = parseTime(aTime);
        final int hours = time[0];
        final int minutes = time[1];
        final int seconds = time[2];

        final boolean secondBlink = seconds % 3 == 0;
        final int hoursTopRow = hours / 5;
        final int hoursSecondRow = hours % 5;
        final int minutesTopRow = minutes / 5;
        final int minutesSecondRow = minutes % 5;

        return printBerlinClock(secondBlink, hoursTopRow, hoursSecondRow, minutesTopRow, minutesSecondRow);
    }

    private int[] parseTime(String aTime) {
        if (aTime == null || aTime.isEmpty()) {
            throw new IllegalArgumentException("Time is required");
        }

        final String[] time = aTime.split(":");
        if (time.length != 3) {
            throw new IllegalArgumentException("Illegal time format, required HH-MM-SS");
        }

        final int hours = Integer.parseInt(time[0]);
        final int minutes = Integer.parseInt(time[1]);
        final int seconds = Integer.parseInt(time[2]);

        return new int[]{hours, minutes, seconds};
    }

    private String printBerlinClock(boolean secondBlink, int hoursTopRow, int hoursSecondRow,
                                    int minutesTopRow, int minutesSecondRow) {
        final StringBuilder berlinClock = new StringBuilder();
        berlinClock.append(secondBlink ? SECOND_BLINK : OFF);
        berlinClock.append("\n");

        printBerlinClockLine(berlinClock, HOURS_TEMPLATE, hoursTopRow);
        berlinClock.append("\n");
        printBerlinClockLine(berlinClock, HOURS_TEMPLATE, hoursSecondRow);
        berlinClock.append("\n");

        printBerlinClockLine(berlinClock, MINUTES_TOP_ROW_TEMPLATE, minutesTopRow);
        berlinClock.append("\n");
        printBerlinClockLine(berlinClock, MINUTES_BOTTOM_ROW_TEMPLATE, minutesSecondRow);

        return berlinClock.toString();
    }

    private void printBerlinClockLine(StringBuilder berlinClock, String template, int blinkLamps) {
        final char[] line = template.toCharArray();
        Arrays.fill(line, blinkLamps, template.length(), OFF);
        berlinClock.append(line);
    }
}
