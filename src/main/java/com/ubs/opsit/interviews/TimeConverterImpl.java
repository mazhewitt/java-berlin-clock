package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;

public class TimeConverterImpl implements TimeConverter{

	private static final int END_NIGHT_HOUR = 24;
	private final static char OFF = 'O';
	private final static String SECOND_ROW_FORMAT = "Y";
	private final static String HOUR_ROW_FORMAT = "RRRR";
	private final static String MINUTE_TOP_ROW_FORMAT = "YYRYYRYYRYY";
	private final static String MINUTE_BOTTOM_ROW_FORMAT = "YYYY";
	private BerlinClock berlinClock;

	
	public String convertTime(String aTime) {
		int[] time = convertTimeStringToLocalTime(aTime);
		berlinClock = buildBerlinClock(time);
		return berlinClock.toString();
	}
	
	private int[] convertTimeStringToLocalTime(String aTime) {
		verifyFormat(aTime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		TemporalAccessor accessor = formatter.parse(aTime);
		LocalTime time = LocalTime.from(accessor);
		Period period = accessor.query(DateTimeFormatter.parsedExcessDays());
		
		int hour = time.getHour();
		if(period.equals(Period.ofDays(1))) {  //This logic to handle "24:00:00" scenerio
			hour = END_NIGHT_HOUR;
		}
		return new int[] {hour, time.getMinute(), time.getSecond()};
	}
	
	private void verifyFormat(String aTime) {
		if (aTime == null || aTime.isEmpty()) {
			throw new IllegalArgumentException("Time is required in the format HH:MM:SS");
		}
		if (!aTime.matches("\\d\\d:\\d\\d:\\d\\d")) {
			throw new IllegalArgumentException("Time must be in the format HH:MM:SS");
		}
	}
	
	private BerlinClock buildBerlinClock(int[] time) {
		String secondRow = (time[2]%2 == 0) ? SECOND_ROW_FORMAT : Character.toString(OFF);
		
		String hoursTopRow = getBerlinClockRow(time[0]/5, HOUR_ROW_FORMAT);
		String hoursBottomRow = getBerlinClockRow(time[0]%5, HOUR_ROW_FORMAT);
		
		String minutesTopRow = getBerlinClockRow(time[1]/5, MINUTE_TOP_ROW_FORMAT);
		String minutesBottomRow = getBerlinClockRow(time[1]%5, MINUTE_BOTTOM_ROW_FORMAT);
		
		return new BerlinClock(secondRow, hoursTopRow, hoursBottomRow, minutesTopRow, minutesBottomRow);
	}

	private String getBerlinClockRow(int numBlinkLamps, String berlinClockRowFormat) {
		char[] row = berlinClockRowFormat.toCharArray();
		Arrays.fill(row, numBlinkLamps, row.length, OFF);
		return String.valueOf(row);
	}
	
	public BerlinClock getBerlinClock() {
		return berlinClock;
	}
}
