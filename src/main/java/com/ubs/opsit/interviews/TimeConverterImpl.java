package com.main;

import java.time.LocalTime;
import java.util.Arrays;

public class TimeConverterImpl implements TimeConverter{

	private final static char OFF = 'O';
	private final static String SECOND_ROW_FORMAT = "Y";
	private final static String HOUR_ROW_FORMAT = "RRRR";
	private final static String MINUTE_TOP_ROW_FORMAT = "YYRYYRYYRYY";
	private final static String MINUTE_BOTTOM_ROW_FORMAT = "YYYY";
	private BerlinClock berlinClock;

	@Override
	public String convertTime(String aTime) {
		LocalTime localTime = convertTimeStringToLocalTime(aTime);
		berlinClock = buildBerlinClock(localTime);
		return berlinClock.toString();
	}
	
	private LocalTime convertTimeStringToLocalTime(String aTime) {
		verifyFormat(aTime);
		return LocalTime.parse(aTime);
	}
	
	private void verifyFormat(String aTime) {
		if (aTime == null || aTime.isEmpty()) {
			throw new IllegalArgumentException("Time is required in the format HH:MM:SS");
		}
		if (!aTime.matches("\\d\\d:\\d\\d:\\d\\d")) {
			throw new IllegalArgumentException("Time must be in the format HH:MM:SS");
		}
	}
	
	private BerlinClock buildBerlinClock(LocalTime localTime) {
		String secondRow = (localTime.getSecond()%2 == 0) ? SECOND_ROW_FORMAT : Character.toString(OFF);
		
		String hoursTopRow = getBerlinClockRow(localTime.getHour()/5, HOUR_ROW_FORMAT);
		String hoursBottomRow = getBerlinClockRow(localTime.getHour()%5, HOUR_ROW_FORMAT);
		
		String minutesTopRow = getBerlinClockRow(localTime.getMinute()/5, MINUTE_TOP_ROW_FORMAT);
		String minutesBottomRow = getBerlinClockRow(localTime.getMinute()%5, MINUTE_BOTTOM_ROW_FORMAT);
		
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
