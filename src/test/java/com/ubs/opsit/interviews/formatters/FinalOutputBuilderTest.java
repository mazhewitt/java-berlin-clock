package com.ubs.opsit.interviews.formatters;

import org.junit.Assert;
import org.junit.Test;

public class FinalOutputBuilderTest {

	@Test
	public void testFinalOutput()
	{
		Assert.assertEquals(
				"O\n" + 
				"RROO\n" + 
				"RRRO\n" + 
				"YYROOOOOOOO\n" + 
				"YYOO",
				new FinalOutputBuilder("13:17:01").getFinalOutput());
		
	}
}
