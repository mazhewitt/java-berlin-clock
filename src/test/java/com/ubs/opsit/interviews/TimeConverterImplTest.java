package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.format.DateTimeParseException;

import org.junit.Test;

public class TimeConverterImplTest {
	
	private TimeConverter timeConverter = new TimeConverterImpl();
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyTime() {
		timeConverter.convertTime("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullTime() {
		timeConverter.convertTime(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectFormat() {
		timeConverter.convertTime("1:2:30");
	}
	
	@Test(expected = DateTimeParseException.class)
	public void testWrongValueInHHMMSS() {
		timeConverter.convertTime("11:20:70");
	}
	
	@Test
    public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
		TimeConverterImpl timeConverter = new TimeConverterImpl();
		timeConverter.convertTime("13:12:10");
        assertEquals("Y", timeConverter.getBerlinClock().getSecondRow());
        
        timeConverter.convertTime("13:12:09");
        assertEquals("O", timeConverter.getBerlinClock().getSecondRow());
    }
	
	@Test
    public void testTopHourRowShouldBlinkRedLampForEvery5Hours() {
		TimeConverterImpl timeConverter = new TimeConverterImpl();
		timeConverter.convertTime("00:12:00");
        assertEquals("OOOO", timeConverter.getBerlinClock().getHoursTopRow());
        
        timeConverter.convertTime("23:12:00");
        assertEquals("RRRR", timeConverter.getBerlinClock().getHoursTopRow());
        
    }
	
	@Test
    public void testBottomHourRowShouldBlinkRedLampForEveryHourRemainedFromTopHours() {
		TimeConverterImpl timeConverter = new TimeConverterImpl();
		timeConverter.convertTime("23:12:00");
        assertEquals("RRRO", timeConverter.getBerlinClock().getHoursBottomRow());
        
        timeConverter.convertTime("13:00:00");
        assertEquals("RRRO", timeConverter.getBerlinClock().getHoursBottomRow());
    }
	
	@Test
    public void testTopRowhouldHave3rd6thAnd9thLampsInRedToShowFirstHalfAndLastQuarter() {
		TimeConverterImpl timeConverter = new TimeConverterImpl();
		timeConverter.convertTime("13:54:00");
        assertEquals("R", timeConverter.getBerlinClock().getMinutesTopRow().substring(2, 3));
        assertEquals("R", timeConverter.getBerlinClock().getMinutesTopRow().substring(5, 6));
        assertEquals("R", timeConverter.getBerlinClock().getMinutesTopRow().substring(8, 9));
    }
	
	@Test
    public void testTopMinuteRowShouldBlinkYellowForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		TimeConverterImpl timeConverter = new TimeConverterImpl();
		timeConverter.convertTime("13:00:00");
        assertEquals("OOOOOOOOOOO", timeConverter.getBerlinClock().getMinutesTopRow());
        
		timeConverter.convertTime("13:59:00");
        assertEquals("YYRYYRYYRYY", timeConverter.getBerlinClock().getMinutesTopRow());
    }
	
	@Test
    public void testBottomMinuteRowCanLightYellowLampForEveryMinuteRemainedFromTopMinuteRow() {
		TimeConverterImpl timeConverter = new TimeConverterImpl();
		timeConverter.convertTime("13:17:00");
        assertEquals("YYOO", timeConverter.getBerlinClock().getMinutesBottomRow());
    }
	
	@Test
	public void testConverterConvertsTimeCorrectInBerlinClockFormat() {
		String actualConvertedTime = timeConverter.convertTime("13:32:10");
		String expectedTime = "Y" + System.lineSeparator() + "RROO" + System.lineSeparator() + "RRRO" + System.lineSeparator() + "YYRYYROOOOO" + System.lineSeparator() + "YYOO" + System.lineSeparator();
		
		assertNotNull(actualConvertedTime);
		assertEquals(expectedTime, actualConvertedTime);
	}
}
