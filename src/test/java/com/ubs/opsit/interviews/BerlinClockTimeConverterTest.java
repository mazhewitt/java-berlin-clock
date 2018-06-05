package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

public class BerlinClockTimeConverterTest {

	BerlinClockTimeConverter berlinClock = new BerlinClockTimeConverter();

	// Yellow lamp should blink on/off every two seconds
	@Test
	public void testTopLampShouldBlinkforTwoSeconds() {
		Assert.assertEquals("Y", berlinClock.calculateSeconds(0));
		Assert.assertEquals("O", berlinClock.calculateSeconds(1));
		Assert.assertEquals("Y", berlinClock.calculateSeconds(2));
		Assert.assertEquals("Y", berlinClock.calculateSeconds(4));
		Assert.assertEquals("O", berlinClock.calculateSeconds(7));
		Assert.assertEquals("O", berlinClock.calculateSeconds(47));

	}

	// First hour row should have 4 lamps
	@Test
	public void testHoursFirstRowShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.calculateHrsFirstRow(7).length());
	}

	// First should light a red lamp for every 5 hours
	@Test
	public void testHoursFirstRowShouldLightRedLampForEvery5Hours() {
		Assert.assertEquals("OOOO", berlinClock.calculateHrsFirstRow(0));
		Assert.assertEquals("RROO", berlinClock.calculateHrsFirstRow(13));
		Assert.assertEquals("RRRR", berlinClock.calculateHrsFirstRow(23));
		Assert.assertEquals("RRRR", berlinClock.calculateHrsFirstRow(24));
	}

	// Second hour row have 4 lamps
	@Test
	public void testHoursSecondRowShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.calculateHrsSecondRow(5).length());
	}

	// Second hour row should light a red lamp for every hour left from first
	// row
	@Test
	public void testHoursSecondRowShouldLightRedLampForEveryHourRemainingFromFirstRow() {
		Assert.assertEquals("OOOO", berlinClock.calculateHrsSecondRow(0));
		Assert.assertEquals("RRRO", berlinClock.calculateHrsSecondRow(13));
		Assert.assertEquals("RRRO", berlinClock.calculateHrsSecondRow(23));
		Assert.assertEquals("RRRR", berlinClock.calculateHrsSecondRow(24));
	}

	// First minutes row should have 11 lamps
	@Test
	public void testTopMinutesShouldHave11Lamps() {
		Assert.assertEquals(11, berlinClock.calculateMinFirstRow(34).length());
	}

	// First minutes row should have 3rd, 6th and 9th lamps in red to indicate
	// first quarter, half and last quarter
	@Test
	public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
		String mins = berlinClock.calculateMinFirstRow(45);
		Assert.assertEquals("R", mins.substring(2, 3));
		Assert.assertEquals("R", mins.substring(5, 6));
		Assert.assertEquals("R", mins.substring(8, 9));
	}

	// First minutes row should light a yellow lamp for every 5 minutes unless
	// it's first quarter, half or last quarter
	@Test
	public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		Assert.assertEquals("OOOOOOOOOOO", berlinClock.calculateMinFirstRow(0));
		Assert.assertEquals("YYROOOOOOOO", berlinClock.calculateMinFirstRow(17));
		Assert.assertEquals("YYRYYRYYRYY", berlinClock.calculateMinFirstRow(59));
	}

	// Second minutes row should have 4 lamps
	@Test
	public void testBottomMinutesShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.calculateMinSecondRow(0).length());
	}

	// Bottom minutes should light a yellow lamp for every minute left from top
	// minutes
	@Test
	public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
		Assert.assertEquals("OOOO", berlinClock.calculateMinSecondRow(0));
		Assert.assertEquals("YYOO", berlinClock.calculateMinSecondRow(17));
		Assert.assertEquals("YYYY", berlinClock.calculateMinSecondRow(59));
	}
}
