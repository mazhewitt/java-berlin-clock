package com.ubs.opsit.impl;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Anjana
 *
 */
public class TimeConverterImplTest {
	
	TimeConverterImpl timeConverter;
	
	@Before
    public void setUp() throws Exception {
    	this.timeConverter = new TimeConverterImpl();
    }
	
	@Test(expected=NumberFormatException.class)
	public void testInvalidTime() {
		timeConverter.convertTime("invalidTime");
	}
	
	@Test
	public void testOddSeconds() {
		assertEquals(timeConverter.getSeconds(13),"O");
	}
	
	@Test
	public void testEvenSeconds() {
		assertEquals(timeConverter.getSeconds(14),"Y");
	}
	
	@Test
	public void testTopHoursAllLampsLighted() {
		assertEquals(timeConverter.getTopHours(20),"RRRR");
	}
	
	@Test
	public void testTopHoursTwoLighted() {
		assertEquals(timeConverter.getTopHours(14),"RROO");
	}
	
	@Test
	public void testTopHoursNoLampsLighted() {
		assertEquals(timeConverter.getTopHours(0),"OOOO");
	}
	
	@Test
	public void testBottomHoursAllLampsLighted() {
		assertEquals(timeConverter.getBottomHours(24),"RRRR");
	}
	
	@Test
	public void testBottomHoursTwoLampsLighted() {
		assertEquals(timeConverter.getBottomHours(12),"RROO");
	}
	
	@Test
	public void testBottomHoursNoLampsLighted() {
		assertEquals(timeConverter.getBottomHours(10),"OOOO");
	}
	
	@Test
	public void testTopMinutesAllLampsLighted() {
		assertEquals(timeConverter.getTopMinutes(59),"YYRYYRYYRYY");
	}
	
	@Test
	public void testTopMinutesTwoLampsLighted() {
		assertEquals(timeConverter.getTopMinutes(12),"YYOOOOOOOOO");
	}
	
	@Test
	public void testTopMinutesNoLampsLighted() {
		assertEquals(timeConverter.getTopMinutes(0),"OOOOOOOOOOO");
	}
	
	@Test
	public void testBottomMinutesAllLampsLighted() {
		assertEquals(timeConverter.getBottomMinutes(59),"YYYY");
	}
	
	@Test
	public void testBottomMinutesTwoLampsLighted() {
		assertEquals(timeConverter.getBottomMinutes(12),"YYOO");
	}
	
	@Test
	public void testBottomMinutesNoLampsLighted() {
		assertEquals(timeConverter.getBottomMinutes(0),"OOOO");
	}
	
}
