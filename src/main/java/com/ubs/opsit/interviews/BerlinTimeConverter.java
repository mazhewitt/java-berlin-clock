package com.ubs.opsit.interviews;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.stream.Stream;

import org.codehaus.plexus.util.StringUtils;

public class BerlinTimeConverter implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		if (validate(aTime)) {
			BerlinClock clock = new BerlinClock();
			clock.setTime(aTime);
			return clock.display();
		} else {
			return "Error : Incorrect time entered";
		}
	}

	private boolean validate(String aTime) {
		String[] numbers = aTime.split(":");
		if (numbers.length != 3)
			return false;
		if (Arrays.stream(numbers).anyMatch(number -> number.length() == 0)) {
			return false;
		}
		if (!Arrays.stream(numbers).allMatch(number -> StringUtils.isNumeric(number))) {
			return false;
		}
		if (Integer.parseInt(numbers[0]) > 24 || Integer.parseInt(numbers[1]) > 59
				|| Integer.parseInt(numbers[2]) > 59) {
			return false;
		}
		return true;
	}

}
