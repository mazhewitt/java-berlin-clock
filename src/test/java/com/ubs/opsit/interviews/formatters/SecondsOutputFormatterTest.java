package com.ubs.opsit.interviews.formatters;

import org.junit.Test;

import com.ubs.opsit.interviews.formatters.SecondsOutputFormatter;

import org.junit.Assert;

public class SecondsOutputFormatterTest {

	
	@Test
	public void testSecondsOutputFormat()
	{
		Assert.assertEquals(1, new SecondsOutputFormatter(0).getSecondsOutput());
		Assert.assertEquals(1, new SecondsOutputFormatter(60).getSecondsOutput());
		Assert.assertEquals(0, new SecondsOutputFormatter(1).getSecondsOutput());
		Assert.assertEquals(0, new SecondsOutputFormatter(59).getSecondsOutput());
		Assert.assertEquals(0, new SecondsOutputFormatter(5).getSecondsOutput());
		
	}
	
	public void testBuildSecondsOutput()
	{
		Assert.assertEquals("Y\n", new SecondsOutputFormatter(0).buildSecondsRow());
		Assert.assertEquals("O\n", new SecondsOutputFormatter(59).buildSecondsRow());
		Assert.assertEquals("Y\n", new SecondsOutputFormatter(0).buildSecondsRow());
		Assert.assertEquals("O\n", new SecondsOutputFormatter(1).buildSecondsRow());
	}
}
