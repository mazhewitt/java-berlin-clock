package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TimeConverterImplTest {
	
	TimeConverterImpl timeConverter = new TimeConverterImpl();
	
	@Test
	public void testCalculateSeconds() {
		String result = timeConverter.calculateSeconds(20);
		assertEquals("Y", result);
	}
	
	@Test
	public void testCalculateSeconds_case2() {
		String result = timeConverter.calculateSeconds(39);
		assertEquals("O", result);
	}
	
	@Test
	public void testCalculateTopHours() {
		String result = timeConverter.calculateTopHours(20);
		assertEquals("RRRR", result);
	}
	
	@Test
	public void testCalculateTopHours_case2() {
		String result = timeConverter.calculateTopHours(13);
		assertEquals("RROO", result);
	}
	
	@Test
    public void testTopHoursLampNumber() {
        int result = timeConverter.calculateTopHours(7).length();
		assertEquals(4, result);
    }
	
	@Test
    public void testBottomHoursLampNumber() {
        int result = timeConverter.calculateBottomHours(7).length();
		assertEquals(4, result);
    }
	
	@Test
	public void testCalculateBottomHours() {
		String result = timeConverter.calculateBottomHours(0);
		assertEquals("OOOO", result);
	}
	
	@Test
	public void testCalculateBottomHours_case2() {
		String result = timeConverter.calculateBottomHours(13);
		assertEquals("RRRO", result);
	}
	
	@Test
	public void testCalculateBottomHours_case3() {
		String result = timeConverter.calculateBottomHours(24);
		assertEquals("RRRR", result);
	}
	
	@Test
	public void testTopMinuteQuarters() {
		String topMin = timeConverter.calculateTopHours(32);
		assertEquals("R", topMin.substring(2, 3));
        assertEquals("R", topMin.substring(5, 6));
	}
	
	@Test
	public void testCalculateTopMinutes() {
		String result = timeConverter.calculateTopMinutes(0);
		assertEquals("OOOOOOOOOOO", result);
	}
	
	@Test
	public void testCalculateTopMinutes_case2() {
		String result = timeConverter.calculateTopMinutes(59);
		assertEquals("YYRYYRYYRYY", result);
	}

	@Test
	public void testTopMinuteLampNumber() {
		int result = timeConverter.calculateTopMinutes(13).length();
		assertEquals(11, result );
	}
	
	@Test
	public void testBottomMinuteLampNumber() {
		int result = timeConverter.calculateBottomMinutes(13).length();
		assertEquals(4, result );
	}
	
	@Test
	public void testCalculateBottomMinutes() {
		String result = timeConverter.calculateBottomMinutes(0);
		assertEquals("OOOO", result);
	}
	
	@Test
	public void testCalculateBottomMinutes_case2() {
		String result = timeConverter.calculateBottomMinutes(59);
		assertEquals("YYYY", result);
	}
	
	@Test
	public void testConvertTime() {
		int result = timeConverter.convertTime("13:19:01").length;
		assertEquals(5, result);
	}
	
	@Test
	public void testConvertTime_case2() {
		String[] result = timeConverter.convertTime("13:10:20");
		String[] expected = new String[] {"Y","RROO","RRRO","YYOOOOOOOOO","OOOO"};
		assertEquals(expected, result);
	}

}
