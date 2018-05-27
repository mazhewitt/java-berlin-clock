package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.time.LocalTime;
import java.time.format.*;

public class BerlinClockConverter implements TimeConverter{
    char OFF_LIGHT = 'O';
    char RED_LIGHT = 'R';
    char YELLOW_LIGHT = 'Y';
    
    private static final String EMPTY_INPUT="Blank Input!!Please provide valid time";    
    private static final String NULL_INPUT="No Input!!Please provide valid time";
    
    private String formClockRows(int hours, int minutes, int seconds)
    {
    	char secondsRow = (seconds % 2 == 0) ? YELLOW_LIGHT : OFF_LIGHT;
        String row1 = String.valueOf(secondsRow);
        String row2 = setTimeOnClockRow(hours / 5, 4, RED_LIGHT);
        String row3 = setTimeOnClockRow(hours % 5, 4, RED_LIGHT);
        String row4 = setTimeOnClockRow(minutes / 5, 11, YELLOW_LIGHT).replaceAll("YYY", "YYR");
        String row5 = setTimeOnClockRow(minutes % 5, 4, YELLOW_LIGHT);

        String berlinClock = String.format("%s\n%s\n%s\n%s\n%s",row1,row2,row3,row4,row5);
        return berlinClock;

    }
   
    private String setTimeOnClockRow(int litLights, int totalLightsInRow, char lampColor)
    {
        char[] row = new char[totalLightsInRow]; //Empty row with provided size
        Arrays.fill(row, OFF_LIGHT);  
        Arrays.fill(row, 0, litLights, lampColor);        	
        return String.valueOf(row);
    }
	    	
	public String convertTime(String inputTime)
	{
		if(inputTime == null)
			throw new IllegalArgumentException(NULL_INPUT);
		if(inputTime.length() == 0)
			throw new IllegalArgumentException(EMPTY_INPUT);
		
		String[] timeUnits = inputTime.split(":");		
		int hours, minutes, seconds = 0;
		String convertedTime="";
        
		if(isTimeFormatValid(inputTime) && timeUnits.length >= 3)
		{
	        hours = Integer.parseInt(timeUnits[0]);
	        minutes = Integer.parseInt(timeUnits[1]);	        
	        seconds = Integer.parseInt(timeUnits[2]);
					        
	        convertedTime = formClockRows(hours,minutes,seconds);
		}
		return convertedTime;
	}
	
	/*Below method Checks parse errors with time with respect to "hh:mm:ss" format.
	This can be further managed to take time format from Locale and convert into required format.
	But not managing conversion for now.*/
	
	public boolean isTimeFormatValid(String inputTime)
	{
		try
		{
			/*Using 'HH:mm' to give 24-hrs clock only.Also enforcing 'HH:mm:ss' format below.
			 If needed below code can be handled to ignore seconds since its small time unit*/
			DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime testTime = LocalTime.parse(inputTime, timeformatter);
		}
		catch(DateTimeParseException timeException)
		{			
			throw timeException;
		}
		return true;
	}
}
