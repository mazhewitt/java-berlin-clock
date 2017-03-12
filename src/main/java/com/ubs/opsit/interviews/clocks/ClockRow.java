package com.ubs.opsit.interviews.clocks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClockRow {

    private final List<ClockLamp> rowLamps;

    public ClockRow(int rowLength, BerlinClockUtilData berlinClockUtilData, LampColorCalculator lampColorCalculator, LampStateCalculator lampStateCalculator) {
        List<ClockLamp> rowLamps = new LinkedList<>();
        for (int i = 0; i < rowLength; i++) {
            rowLamps.add(new ClockLamp(lampColorCalculator.calculateLampColor(i), lampStateCalculator.calculateLampState(berlinClockUtilData, i)));
        }
        this.rowLamps = Collections.unmodifiableList(rowLamps);
    }

    public List<ClockLamp> getRowLamps() {
        return rowLamps;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        rowLamps.forEach(rowLamp -> stringBuilder.append(rowLamp.toString()));
        return stringBuilder.toString();
    }

    @FunctionalInterface
    interface LampColorCalculator {
        ClockLamp.Color calculateLampColor(int position);
    }

    @FunctionalInterface
    interface LampStateCalculator {
        ClockLamp.State calculateLampState(BerlinClockUtilData berlinClockUtilData, int position);
    }

}
