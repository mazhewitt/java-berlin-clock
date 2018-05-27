package com.ubs.opsit.interviews;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.format.DateTimeParseException;

public class BerlinClockTestErrors {
	public TimeConverter timeConverter = new BerlinClockConverter();
	//Service which test code/client can call as needed 	
	public String ConvertTimeToBerlinClock(String inputTime)
	{				
		return timeConverter.convertTime(inputTime);
	}


	@Test(expected = DateTimeParseException.class)
    public void testInvalidInput() throws DateTimeParseException{
		System.out.println("==========================");
		System.out.println("Test: testInValidTime");
		try
    	{
    		ConvertTimeToBerlinClock("20:00");
    	}
    	catch(DateTimeParseException exp)
    	{    		
    		System.out.println("Incorrect format; Ensure correct time range and format 'hh:mm:ss'");
    		throw exp;
    	}
    }

   @Test(expected = IllegalArgumentException.class)
    public void testEmptyInput() {
	    System.out.println("==========================");
    	System.out.println("Test: testEmptyInput");
    	ConvertTimeToBerlinClock("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullString() {
    	System.out.println("==========================");
    	System.out.println("Test: testNullString");
    	ConvertTimeToBerlinClock(null);
    }
	
   //Basic test method called from other error testcases
    public void testInvalidTimeUnits(String iTime)
    {
    	try{
    		ConvertTimeToBerlinClock(iTime);
    	}
    	catch(Exception exp){    		
    		System.out.println(exp.getMessage());
    		throw exp;
    	}
    }

    @Test(expected = DateTimeParseException.class)
    public void testInvalidHours() {
    	System.out.println("==========================");
		System.out.println("Test: testInvalidHours");
		testInvalidTimeUnits("28:00:00");
    }
		
    @Test(expected = DateTimeParseException.class)
    public void testInvalidMinutes() {
    	System.out.println("==========================");
    	System.out.println("Test: testInvalidMinutes");
		testInvalidTimeUnits("00:65:00");
    }
    
    @Test(expected = DateTimeParseException.class)
    public void testInvalidSeconds() {
    	System.out.println("==========================");
    	System.out.println("Test: testInvalidSeconds");
		testInvalidTimeUnits("00:00:60");
    }

    @Test(expected = DateTimeParseException.class)
    public void testNegativeHours() {
    	System.out.println("==========================");
    	System.out.println("Test: testNegativeHours");
		testInvalidTimeUnits("-30:00:00");
    }
    
    @Test(expected = DateTimeParseException.class)
    public void testNegativeMinutes() {
    	System.out.println("==========================");
    	System.out.println("Test: testNegativeMinutes");
		testInvalidTimeUnits("00:-20:00");
    }
    
    @Test(expected = DateTimeParseException.class)
    public void testNegativeSeconds() {
    	System.out.println("==========================");
    	System.out.println("Test: testNegativeSeconds");
		testInvalidTimeUnits("00:00:-20");
    }
}
