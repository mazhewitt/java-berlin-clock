package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

public class BerlinClockUnitTests

{

	private TimeConverter timer = new BerlinTimeConverter();

	@Test
	public void testNonNumericSeconds() {
		Assert.assertEquals(timer.convertTime("12:00:xx"), "Error : Incorrect time entered");
	}

	@Test
	public void testNonNumericMins() {
		Assert.assertEquals(timer.convertTime("12:xx:00"), "Error : Incorrect time entered");
	}

	@Test
	public void testNonNumericHours() {
		Assert.assertEquals(timer.convertTime("xx:00:00"), "Error : Incorrect time entered");
	}

	@Test
	public void testOutOfBoundHours() {
		Assert.assertEquals(timer.convertTime("25:00:00"), "Error : Incorrect time entered");
	}

	@Test
	public void testOutOfBoundMins() {
		Assert.assertEquals(timer.convertTime("12:60:00"), "Error : Incorrect time entered");
	}

	@Test
	public void testOutOfBoundSeconds() {
		Assert.assertEquals(timer.convertTime("12:00:60"), "Error : Incorrect time entered");
	}

	@Test
	public void testWithoutSeconds() {
		Assert.assertEquals(timer.convertTime("12:00:"), "Error : Incorrect time entered");
	}

	@Test
	public void testWithoutMins() {
		Assert.assertEquals(timer.convertTime("12::00"), "Error : Incorrect time entered");
	}

	@Test
	public void testWithoutHours() {
		Assert.assertEquals(timer.convertTime(":00:00"), "Error : Incorrect time entered");
	}

	@Test
	public void testInCorrectTime() {
		Assert.assertEquals(timer.convertTime(":00:00"), "Error : Incorrect time entered");
	}

	@Test
	public void checkYellowLampOffDisplay() {
		Lamp lamp = new YellowLamp(1);
		lamp.switchOn();
		Assert.assertEquals(lamp.display(), 'Y');
	}

	@Test
	public void checkYellowLampOnDisplay() {
		Lamp lamp = new YellowLamp(1);
		lamp.switchOff();
		Assert.assertEquals(lamp.display(), 'O');
	}

	@Test
	public void checkRedLampOnDisplay() {
		Lamp lamp = new RedLamp(1);
		lamp.switchOn();
		Assert.assertEquals(lamp.display(), 'R');
	}

	@Test
	public void checkRedLampOffDisplay() {
		Lamp lamp = new RedLamp(1);
		lamp.switchOff();
		Assert.assertEquals(lamp.display(), 'O');
	}

	@Test
	public void checkPositive() {
		String expected = "Y" + "\r\n" + "RRRR" + "\r\n" + "RRRO" + "\r\n" + "YYRYYRYYRYY" + "\r\n" + "YYYY";
		Assert.assertEquals(timer.convertTime("23:59:58"), expected);
	}

}