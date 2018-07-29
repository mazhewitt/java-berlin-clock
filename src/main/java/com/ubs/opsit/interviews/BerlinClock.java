package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BerlinClock {

	List<Row> timeRows = new ArrayList<>();

	Function<String, Integer> conversionFunction = time -> (Integer.parseInt(time.substring(0, 2)) / 5);

	public BerlinClock() {
		Row secondsRow = new SecondsRow(time -> (Integer.parseInt(time.substring(6, 8)) % 2));
		secondsRow.getLamps().add(new YellowLamp(2));
		timeRows.add(secondsRow);

		Row fiveHourRow = new HourRow(time -> (Integer.parseInt(time.substring(0, 2)) / 5));
		fiveHourRow.getLamps().add(new RedLamp(5));
		fiveHourRow.getLamps().add(new RedLamp(5));
		fiveHourRow.getLamps().add(new RedLamp(5));
		fiveHourRow.getLamps().add(new RedLamp(5));
		timeRows.add(fiveHourRow);

		Row oneHourRow = new HourRow(time -> (Integer.parseInt(time.substring(0, 2)) % 5));
		oneHourRow.getLamps().add(new RedLamp(1));
		oneHourRow.getLamps().add(new RedLamp(1));
		oneHourRow.getLamps().add(new RedLamp(1));
		oneHourRow.getLamps().add(new RedLamp(1));
		timeRows.add(oneHourRow);

		Row fiveMinutesRow = new MinuteRow(time -> (Integer.parseInt(time.substring(3, 5)) / 5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		fiveMinutesRow.getLamps().add(new RedLamp(5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		fiveMinutesRow.getLamps().add(new RedLamp(5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		fiveMinutesRow.getLamps().add(new RedLamp(5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		fiveMinutesRow.getLamps().add(new YellowLamp(5));
		timeRows.add(fiveMinutesRow);

		Row oneMinRow = new MinuteRow(time -> (Integer.parseInt(time.substring(3,5)) % 5));
		oneMinRow.getLamps().add(new YellowLamp(1));
		oneMinRow.getLamps().add(new YellowLamp(1));
		oneMinRow.getLamps().add(new YellowLamp(1));
		oneMinRow.getLamps().add(new YellowLamp(1));
		timeRows.add(oneMinRow);
	}

	public void setTime(String time) {
		for (Row row : timeRows) {
			row.setTime(time);
		}
	}

	public String display() {
		StringBuilder sb = new StringBuilder();
		for (Row row : timeRows) {
			if(sb.length()!=0) {
				sb.append("\r\n");
			}
			sb.append(row.display());
		}
		return sb.toString();
	}
}
