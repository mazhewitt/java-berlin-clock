package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TimeConverterImpl implements TimeConverter {
    public static final int UNIT_GROUP_SIZE = 5;
    public static final char DEFAULT_EMPTY_CHAR = 'O';
    public static final char RED_CHAR = 'R';
    public static final char YELLOW_CHAR = 'Y';

    @Override
    public String convertTime(String aTime) {
        TimeUnits timeUnits = parseHoursMinutesSeconds(aTime);
        String secsRow = getSecsRow(timeUnits);
        String hoursRowFirst = buildRow(timeUnits.getHours() / UNIT_GROUP_SIZE, 4, i -> RED_CHAR);
        String hoursRowSecond = buildRow(timeUnits.getHours() % UNIT_GROUP_SIZE, 4, i -> RED_CHAR);
        String minsRowFirst = buildRow(timeUnits.getMins() / UNIT_GROUP_SIZE, 11, i -> i % 3 == 0 ? RED_CHAR : YELLOW_CHAR);
        String minsRowSecond = buildRow(timeUnits.getMins() % UNIT_GROUP_SIZE, 4, i -> YELLOW_CHAR);
        return format(secsRow, hoursRowFirst, hoursRowSecond, minsRowFirst, minsRowSecond);
    }

    private static String getSecsRow(TimeUnits timeUnits) {
        return "" + (timeUnits.getSecs() % 2 == 0 ? YELLOW_CHAR : DEFAULT_EMPTY_CHAR);
    }

    private static String format(String... rows) {
        return Arrays.stream(rows)
                .collect(Collectors.joining(System.getProperty("line.separator")));
    }

    private static String buildRow(int numberOfItemsToPrint, int maxItemsInRow, Function<Integer, Character> indexToPrintCharMapper) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numberOfItemsToPrint; i++) {
            sb.append(indexToPrintCharMapper.apply(i));
        }
        for (int i = numberOfItemsToPrint + 1; i <= maxItemsInRow; i++) {
            sb.append(DEFAULT_EMPTY_CHAR);
        }
        return sb.toString();
    }

    private static TimeUnits parseHoursMinutesSeconds(String aTime) {
        List<Integer> timeParts = Arrays.stream(aTime.split(":")).map(Integer::new).collect(Collectors.toList());
        return new TimeUnits(timeParts);
    }

    static class TimeUnits {
        final int hours;
        final int mins;
        final int secs;

        public TimeUnits(List<Integer> timeParts) {
            this.hours = timeParts.get(0);
            this.mins = timeParts.get(1);
            this.secs = timeParts.get(2);
        }

        public int getHours() {
            return hours;
        }

        public int getMins() {
            return mins;
        }

        public int getSecs() {
            return secs;
        }
    }
}
