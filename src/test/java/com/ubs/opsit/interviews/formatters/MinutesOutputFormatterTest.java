package com.ubs.opsit.interviews.formatters;

import org.junit.Test;

import com.ubs.opsit.interviews.formatters.MinutesOutputFormatter;

import org.junit.Assert;

public class MinutesOutputFormatterTest {
	
	@Test
	public void testMinutesUpperRow() {
		Assert.assertEquals(3, new MinutesOutputFormatter(17).getMinutesUperRow());
		Assert.assertEquals(11, new MinutesOutputFormatter(55).getMinutesUperRow());
		Assert.assertEquals(11, new MinutesOutputFormatter(56).getMinutesUperRow());
		Assert.assertEquals(0, new MinutesOutputFormatter(0).getMinutesUperRow());
		Assert.assertEquals(1, new MinutesOutputFormatter(5).getMinutesUperRow());
	}
	
	@Test
	public void testMinutesLowerRow() {
		Assert.assertEquals(2, new MinutesOutputFormatter(17).getMinutesLowerRow());
		Assert.assertEquals(0, new MinutesOutputFormatter(55).getMinutesLowerRow());
		Assert.assertEquals(1, new MinutesOutputFormatter(56).getMinutesLowerRow());
		Assert.assertEquals(0, new MinutesOutputFormatter(0).getMinutesLowerRow());
		Assert.assertEquals(0, new MinutesOutputFormatter(5).getMinutesLowerRow());
	}
	
	@Test
	public void testBuildMinutesOutput()
	{
		Assert.assertEquals("YYROOOOOOOO\n" + "YYOO",new MinutesOutputFormatter(17).buildMinutesRows());
		Assert.assertEquals("YYRYYRYYRYY\n" + "OOOO",new MinutesOutputFormatter(55).buildMinutesRows());
		Assert.assertEquals("YYRYYRYYRYY\n" + "YOOO",new MinutesOutputFormatter(56).buildMinutesRows());
		Assert.assertEquals("OOOOOOOOOOO\n" + "OOOO",new MinutesOutputFormatter(0).buildMinutesRows());
		Assert.assertEquals("YOOOOOOOOOO\n" + "OOOO",new MinutesOutputFormatter(5).buildMinutesRows());
	}

}
