/**
 * 
 */
package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author z001n8q
 *
 */
public class BerlinClockTimeConverter implements TimeConverter {

	private static Pattern hhmissFormat = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
	public static String newline = System.getProperty("line.separator");

	private Integer hour;
	private Integer minute;
	private Integer second;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 */
	@Override
	public String convertTime(String aTime) {
		StringBuilder output = new StringBuilder();
		if (validateAndSetInput(aTime)) {
			validateRange();
			if (chkEven(this.getSecond())) {
				output.append("Y");
			} else {
				output.append("O");
			}
			output.append(newline);
			appendHourRows(output);
			appendMinuteRows(output);
		}
		return output.toString();
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	/**
	 * Validate the String format with the pattern matcher also set the hour
	 * minute and second variables
	 * 
	 * @param aTime
	 *            input times
	 * @return boolean if matches
	 */
	private boolean validateAndSetInput(String aTime) {

		Matcher matchInputString = hhmissFormat.matcher(aTime);
		if (matchInputString.matches()) {
			setHour(Integer.parseInt(matchInputString.group(1)));
			setMinute(Integer.parseInt(matchInputString.group(2)));
			setSecond(Integer.parseInt(matchInputString.group(3)));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validate the range of input to check the boundary conditions
	 * 
	 * @return boolean
	 */
	private void validateRange() {
		if (this.hour < 0 || this.hour > 24) {
			throw new IllegalArgumentException("hours range should be between 00 - 24");
		}
		if (this.minute < 0 || this.minute > 59) {
			throw new IllegalArgumentException("minutes range should be between 00 - 59");
		}
		if (this.second < 0 || this.second > 59) {
			throw new IllegalArgumentException("seconds range should be between of 00 - 59");
		}
		if (24 == this.hour && (this.minute != 0 || this.second != 0)) {
			throw new IllegalArgumentException("Hours can be 24 only in case of 24:00:00");
		}
	}

	/**
	 * For checking the second value is even or odd
	 * 
	 * @param input
	 * @return boolean value of check
	 */
	private boolean chkEven(Integer input) {
		if ((input % 2) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This will append the hour rows in StringBuilder objects
	 * 
	 * @param sbf
	 */
	private void appendHourRows(StringBuilder sbf) {
		int quot = this.getHour() / 5;
		int remainder = this.getHour() % 5;

		loopAndAppend(sbf, quot, "R", false, 0);
		loopAndAppend(sbf, 4 - quot, "O", false, 0);
		sbf.append(newline);

		loopAndAppend(sbf, remainder, "R", false, 0);
		loopAndAppend(sbf, 4 - remainder, "O", false, 0);
		sbf.append(newline);

	}

	/**
	 * Append the minute rows in the StringBuilder objects
	 * 
	 * @param sbf
	 */
	private void appendMinuteRows(StringBuilder sbf) {

		int quot = this.getMinute() / 5;
		int remainder = this.getMinute() % 5;

		loopAndAppend(sbf, quot, "Y", true, 3);
		loopAndAppend(sbf, 11 - quot, "O", false, 0);
		sbf.append(newline);

		loopAndAppend(sbf, remainder, "Y", false, 0);
		loopAndAppend(sbf, 4 - remainder, "O", false, 0);
	}

	/**
	 * Loop the appender based on the threshold, append value in the
	 * StringBuilder based on appender, factor3Switch for the minute first row
	 * logic, in case true pass the factorValue
	 * 
	 * @param sbf
	 * @param threshold
	 * @param appender
	 * @param factor3Switch
	 */
	private void loopAndAppend(StringBuilder sbf, int threshold, String appender, boolean factor3Switch,
			int factorValue) {
		for (int i = 1; i <= threshold; i++) {
			if (factor3Switch) {
				if (i > 0 && (i % factorValue) == 0) {
					sbf.append("R");
				} else {
					sbf.append(appender);
				}
			} else {
				sbf.append(appender);
			}
		}
	}

}
