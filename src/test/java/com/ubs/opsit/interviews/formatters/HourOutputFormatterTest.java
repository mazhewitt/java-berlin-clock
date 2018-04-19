package com.ubs.opsit.interviews.formatters;


import org.junit.Test;

import com.ubs.opsit.interviews.formatters.HourOutputFormatter;

import org.junit.Assert;

public class HourOutputFormatterTest {

	
	@Test
	public void testHourUpperRow() {
		Assert.assertEquals(0, new HourOutputFormatter(0).getHoursUpperLamps());
		Assert.assertEquals(2, new HourOutputFormatter(13).getHoursUpperLamps());
		Assert.assertEquals(0, new HourOutputFormatter(1).getHoursUpperLamps());
		Assert.assertEquals(0, new HourOutputFormatter(4).getHoursUpperLamps());
		Assert.assertEquals(1, new HourOutputFormatter(5).getHoursUpperLamps());
	}
	
	@Test
	public void testHourLowerRow() {
		Assert.assertEquals(3, new HourOutputFormatter(13).getHoursLowerLamps());
		Assert.assertEquals(3, new HourOutputFormatter(3).getHoursLowerLamps());
		Assert.assertEquals(4, new HourOutputFormatter(4).getHoursLowerLamps());
		Assert.assertEquals(0, new HourOutputFormatter(5).getHoursLowerLamps());
		Assert.assertEquals(1, new HourOutputFormatter(6).getHoursLowerLamps());
	}
	
	@Test
	public void testBuildHourOutput()
	{
		Assert.assertEquals("RROO\n" + "RRRO\n",new HourOutputFormatter(13).buildHoursRows());
		Assert.assertEquals("ROOO\n" + "ROOO\n",new HourOutputFormatter(6).buildHoursRows());
		Assert.assertEquals("OOOO\n" + "RRRR\n",new HourOutputFormatter(4).buildHoursRows());
		Assert.assertEquals("ROOO\n" + "OOOO\n",new HourOutputFormatter(5).buildHoursRows());
	}
}
