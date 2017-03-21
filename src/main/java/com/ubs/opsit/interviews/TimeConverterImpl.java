package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConverterImpl implements TimeConverter {

    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String MIDNIGHT = "24:00:00";

    @Override
    public String convertTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
        LocalTime dateTime = LocalTime.parse(time, formatter);
        BerlinClock clockModel = new BerlinClock();
        if (time.equals(MIDNIGHT)) {
            clockModel.setTime(24, 00, 00);
        } else {
            clockModel.setTime(dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());
        }
        return clockModel.buildClock();
    }
}
