package com.main;

import static org.junit.Assert.assertNotNull;

import java.time.format.DateTimeParseException;

import org.junit.Test;

public class TimeConverterImplTest { 
	
	private TimeConverter converter = new TimeConverterImpl();

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyTime() {
		converter.convertTime("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullTime() {
		converter.convertTime(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectFormat() {
		converter.convertTime("1:2:30");
	}
	
	@Test(expected = DateTimeParseException.class)
	public void testWrongValueInHHMMSS() {
		converter.convertTime("11:20:70");
	}
	
	@Test
	public void canConverterConvertTimeToBerlinClock() {
		String convertTime = converter.convertTime("13:12:10");
		System.out.println(convertTime);
		assertNotNull(convertTime);
	}
}
