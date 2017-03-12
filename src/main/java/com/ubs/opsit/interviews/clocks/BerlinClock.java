package com.ubs.opsit.interviews.clocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Immutable Berlin Uhr clock object representation
 *
 * @author Roman Lebedev
 */
public class BerlinClock {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final int hours;
    private final int minutes;
    private final int seconds;
    private final BerlinClockUtilData berlinClockUtilData;
    private final List<ClockRow> clockRows;

    /**
     * @param hours   hours in 24h format, in range of 00-24
     * @param minutes minutes in range of 00-59
     * @param seconds seconds in range of 00-59
     * @throws IllegalArgumentException if time passed is not a valid time in range of 00:00:00 - 24:00:00
     */
    public BerlinClock(int hours, int minutes, int seconds) {
        log.trace("creating new berlin clock instance with params: hours={}, minutes={}, seconds={}", hours, minutes, seconds);
        validate(hours, minutes, seconds);
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.berlinClockUtilData = new BerlinClockUtilData(hours, minutes, seconds);
        log.trace("calculated berlin clock util data = {}", this.berlinClockUtilData);
        this.clockRows = Collections.unmodifiableList(getClockRows());
    }

    @Override
    public String toString() {
        return clockRows.stream().map(ClockRow::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    private void validate(int hours, int minutes, int seconds) {
        if (hours < 0 || hours > 24) {
            throw new IllegalArgumentException("hours can only be in range of 00 - 24");
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("minutes can only be in range of 00 - 59");
        }
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("seconds can only be in range of 00 - 59");
        }
        if (24 == hours && (minutes != 0 || seconds != 0)) {
            throw new IllegalArgumentException("Hours can be 24 only in case of 24:00:00");
        }
    }

    private List<ClockRow> getClockRows() {
        List<ClockRow> rows = new LinkedList<>();

        ClockRow secondsRow = new ClockRow(1, berlinClockUtilData,
                (position) -> ClockLamp.Color.YELLOW,
                (berlinClockUtilData, position) -> berlinClockUtilData.getSecondsMod2() == 0 ? ClockLamp.State.SWITCHED_ON : ClockLamp.State.SWITCHED_OFF
        );

        ClockRow hours1stRow = new ClockRow(4, berlinClockUtilData,
                (position) -> ClockLamp.Color.RED,
                (berlinClockUtilData, position) -> position < berlinClockUtilData.getHoursDiv5() ? ClockLamp.State.SWITCHED_ON : ClockLamp.State.SWITCHED_OFF
        );

        ClockRow hours2ndRow = new ClockRow(4, berlinClockUtilData,
                (position) -> ClockLamp.Color.RED,
                (berlinClockUtilData, position) -> position < berlinClockUtilData.getHoursMod5() ? ClockLamp.State.SWITCHED_ON : ClockLamp.State.SWITCHED_OFF
        );

        ClockRow minutes1stRow = new ClockRow(11, berlinClockUtilData,
                (position) -> (position + 1) % 3 == 0 ? ClockLamp.Color.RED : ClockLamp.Color.YELLOW,
                (berlinClockUtilData, position) -> position < berlinClockUtilData.getMinutesDiv5() ? ClockLamp.State.SWITCHED_ON : ClockLamp.State.SWITCHED_OFF
        );

        ClockRow minutes2ndRow = new ClockRow(4, berlinClockUtilData,
                (position) -> ClockLamp.Color.YELLOW,
                (berlinClockUtilData, position) -> position < berlinClockUtilData.getMinutesMod5() ? ClockLamp.State.SWITCHED_ON : ClockLamp.State.SWITCHED_OFF
        );

        rows.add(secondsRow);
        rows.add(hours1stRow);
        rows.add(hours2ndRow);
        rows.add(minutes1stRow);
        rows.add(minutes2ndRow);
        return rows;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}