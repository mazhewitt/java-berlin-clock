/**
 * 
 */
package com.ubs.opsit.impl;

import java.util.stream.Stream;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.util.Constants;

/**
 * @author Anjana
 *
 */
public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		String[] time = aTime.split(":");
		int hours = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		int seconds = Integer.parseInt(time[2]);

		StringBuilder berlinTime = new StringBuilder();
		berlinTime.append(getSeconds(seconds));
		berlinTime.append(Constants.NEWLINE);
		berlinTime.append(getTopHours(hours));
		berlinTime.append(Constants.NEWLINE);
		berlinTime.append(getBottomHours(hours));
		berlinTime.append(Constants.NEWLINE);
		berlinTime.append(getTopMinutes(minutes));
		berlinTime.append(Constants.NEWLINE);
		berlinTime.append(getBottomMinutes(minutes));
		return berlinTime.toString();
	}

	String getBottomMinutes(int minutes) {
		char bottomMinutes[] = Constants.DEFAULT_TIME.toCharArray();
		int yellowLamp = minutes % 5;
		for (int index = 0; index < yellowLamp; index++) {
			bottomMinutes[index] = 'Y';
		}
		return new String(bottomMinutes);

	}

	String getTopMinutes(int minutes) {
		char topMinutes[] = Constants.DEFAULT_TOP_MINUTES.toCharArray();
		int lightedLamp = minutes / 5;
		for (int index = 0; index < lightedLamp; index++) {
			if ((index + 1) % 3 == 0) {
				topMinutes[index] = 'R';
			} else {
				topMinutes[index] = 'Y';
			}
		}
		return new String(topMinutes);

	}

	String getTopHours(int hours) {
		char topHours[] = Constants.DEFAULT_TIME.toCharArray();
		int redLamp = hours / 5;
		for (int index = 0; index < redLamp; index++) {
			topHours[index] = 'R';
		}
		return new String(topHours);
	}

	String getBottomHours(int hours) {
		char bottomHours[] = Constants.DEFAULT_TIME.toCharArray();
		int redLamp = hours % 5;
		for (int index = 0; index < redLamp; index++) {
			bottomHours[index] = 'R';
		}
		return new String(bottomHours);
	}

	String getSeconds(int seconds) {
		return seconds % 2 == 0 ? "Y" : "O";
	}

}
