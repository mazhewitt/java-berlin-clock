package com.ubs.opsit.interviews;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.format.DateTimeParseException;

public class BerlinClockTest {
	public TimeConverter timeConverter = new BerlinClockConverter();
	//Service which test code/client can call as needed 	
	public String ConvertTimeToBerlinClock(String inputTime)
	{				
		return timeConverter.convertTime(inputTime);
	}


    @Test
    public void test1BerlinClock() {
        String clockOutput = ConvertTimeToBerlinClock("23:30:05");        
        String expectedOutput = "O\n" +
                "RRRR\n" +
                "RRRO\n" +
                "YYRYYROOOOO\n" +
                "OOOO";

        assertEquals(expectedOutput, clockOutput);
    }

    @Test
    public void test2BerlinClock() {
        String clockOutput = ConvertTimeToBerlinClock("03:59:01");        
        String expectedOutput = "O\n" +
                "OOOO\n" +
                "RRRO\n" +
                "YYRYYRYYRYY\n" +
                "YYYY";

        assertEquals(expectedOutput, clockOutput);
    }

    @Test
    public void testMaximumPossibleTime() {
    	assertNotNull(ConvertTimeToBerlinClock("23:59:59"));
    }

    @Test
    public void testMinimumPossibleTime() {
    	assertNotNull(ConvertTimeToBerlinClock("00:00:00"));
    }
}
