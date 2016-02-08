package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.util.Arrays;

/**
 * Implementation of Berlin Clock time converter.
 * Example of usage:
 * new TimeConverterImpl().convertTime("13:17:01")
 */
public class TimeConverterImpl implements TimeConverter {

    private static final String SECOND_BLINK = "Y";
    private static final char OFF = 'O';

    private static final String HOURS_TEMPLATE = "RRRR";
    private static final String MINUTES_TOP_ROW_TEMPLATE = "YYRYYRYYRYY";
    private static final String MINUTES_BOTTOM_ROW_TEMPLATE = "YYYY";

    private static class BerlinClock {
        final boolean secondBlink;
        final int hoursTopRow;
        final int hoursSecondRow;
        final int minutesTopRow;
        final int minutesSecondRow;

        private BerlinClock(boolean secondBlink, int hoursTopRow, int hoursSecondRow, int minutesTopRow, int minutesSecondRow) {
            this.secondBlink = secondBlink;
            this.hoursTopRow = hoursTopRow;
            this.hoursSecondRow = hoursSecondRow;
            this.minutesTopRow = minutesTopRow;
            this.minutesSecondRow = minutesSecondRow;
        }
    }

    /**
     * Converts time from HH-MM-SS format into Berlin Clock format
     *
     * @param aTime time in format HH-MM-SS
     * @return Berlin Clock format
     */
    @Override
    public String convertTime(String aTime) {
        final LocalTime time = LocalTime.parse(aTime);
        final BerlinClock berlinClock = calculateBerlinClock(time);
        return printBerlinClock(berlinClock);
    }

    private BerlinClock calculateBerlinClock(LocalTime time) {
        final boolean secondBlink = time.getSecond() % 3 == 0;
        final int hoursTopRow = time.getHour() / 5;
        final int hoursSecondRow = time.getHour() % 5;
        final int minutesTopRow = time.getMinute() / 5;
        final int minutesSecondRow = time.getMinute() % 5;
        return new BerlinClock(secondBlink, hoursTopRow, hoursSecondRow, minutesTopRow, minutesSecondRow);
    }

    private String printBerlinClock( BerlinClock bc) {
        final StringBuilder berlinClock = new StringBuilder();
        berlinClock.append(bc.secondBlink ? SECOND_BLINK : OFF);
        berlinClock.append(System.lineSeparator());

        printBerlinClockLine(berlinClock, HOURS_TEMPLATE, bc.hoursTopRow);
        berlinClock.append(System.lineSeparator());
        printBerlinClockLine(berlinClock, HOURS_TEMPLATE, bc.hoursSecondRow);
        berlinClock.append(System.lineSeparator());

        printBerlinClockLine(berlinClock, MINUTES_TOP_ROW_TEMPLATE, bc.minutesTopRow);
        berlinClock.append(System.lineSeparator());
        printBerlinClockLine(berlinClock, MINUTES_BOTTOM_ROW_TEMPLATE, bc.minutesSecondRow);

        return berlinClock.toString();
    }

    private void printBerlinClockLine(StringBuilder berlinClock, String template, int blinkLamps) {
        final char[] line = template.toCharArray();
        Arrays.fill(line, blinkLamps, template.length(), OFF);
        berlinClock.append(line);
    }
}
