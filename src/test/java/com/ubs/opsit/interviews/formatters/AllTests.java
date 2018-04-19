package com.ubs.opsit.interviews.formatters;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FinalOutputBuilderTest.class, HourOutputFormatterTest.class, MinutesOutputFormatterTest.class,
		SecondsOutputFormatterTest.class })
public class AllTests {

}
