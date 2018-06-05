/**
 * 
 */
package com.ubs.opsit.interviews;

import java.util.stream.Stream;

/**
 * This class implementation converts time as per Berlin clock
 * 
 * @author Yash Khakhar
 *
 */
public class BerlinClockTimeConverter implements TimeConverter {

	private static String YELLOW_LAMP = "Y";
	private static String RED_LAMP = "R";
	private static String OFF = "O";
	private static String NEW_LINE = "\r\n";

	/*
	 * The input time in (HH:MM:SS) format is converted to berlin clock format.
	 */
	@Override
	public String convertTime(String aTime) {
		int[] parts = Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray();

		StringBuilder convTime = new StringBuilder();
		convTime.append(calculateSeconds(parts[2]) + NEW_LINE);
		convTime.append(calculateHrsFirstRow(parts[0]) + NEW_LINE);
		convTime.append(calculateHrsSecondRow(parts[0]) + NEW_LINE);
		convTime.append(calculateMinFirstRow(parts[1]) + NEW_LINE);
		convTime.append(calculateMinSecondRow(parts[1]));

		return convTime.toString();
	}

	protected String calculateSeconds(int number) {
		if (number % 2 == 0)
			return YELLOW_LAMP;
		else
			return OFF;
	}

	protected String calculateHrsFirstRow(int number) {
		return getOnOff(4, calFirstRowSigns(number));
	}

	protected String calculateHrsSecondRow(int number) {
		return getOnOff(4, number % 5);
	}

	protected String calculateMinFirstRow(int number) {
		return getOnOff(11, calFirstRowSigns(number), YELLOW_LAMP).replaceAll("YYY", "YYR");
	}

	protected String calculateMinSecondRow(int number) {
		return getOnOff(4, number % 5, YELLOW_LAMP);
	}

	private String getOnOff(int lamps, int onSigns) {
		return getOnOff(lamps, onSigns, RED_LAMP);
	}

	private String getOnOff(int lamps, int onSigns, String onSign) {
		String out = "";
		for (int i = 0; i < onSigns; i++) {
			out += onSign;
		}
		for (int i = 0; i < (lamps - onSigns); i++) {
			out += OFF;
		}
		return out;
	}

	private int calFirstRowSigns(int number) {
		return (number - (number % 5)) / 5;
	}
}
