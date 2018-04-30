package com.ubs.opsit.interviews.model;

import static com.ubs.opsit.interviews.utils.ValidateUtils.*;

public class Time {

    private final int hour;
    private final int minutes;
    private final int seconds;

    public Time(int hour, int minutes, int seconds){
        validateRangeFromZeroUpTo(24, hour, "hour");
        validateRangeFromZeroUntil(60, minutes, "minutes");
        validateRangeFromZeroUntil(60, seconds, "seconds");
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
