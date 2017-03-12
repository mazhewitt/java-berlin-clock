package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.clocks.BerlinClock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class BerlinClockTimeConverter implements TimeConverter {

    @Override
    public String convertTime(String aTime) {
        BerlinClock berlinClock;
        if ("24:00:00".equals(aTime)) { //nor java8.time nor joda-time supports "24:00:00" end of day, cheapest workaround
            berlinClock = new BerlinClock(24, 0, 0);
        } else { //DateTimeFormatter will do all the validation and throw exception if needed
            LocalTime localTime = LocalTime.parse(aTime, DateTimeFormatter.ISO_LOCAL_TIME.withResolverStyle(ResolverStyle.STRICT));
            berlinClock = new BerlinClock(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        }
        return berlinClock.toString();
    }

}
