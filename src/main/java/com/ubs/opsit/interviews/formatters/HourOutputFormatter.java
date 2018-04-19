package com.ubs.opsit.interviews.formatters;

public class HourOutputFormatter {
	
	private int CURRENT_HOURS;
	private int UPPER_LAMP_VALUE = 5;
	private StringBuilder UPPER_LAMPS_ROW = new StringBuilder("OOOO");
	private StringBuilder LOWER_LAMPS_ROW = new StringBuilder("OOOO");
	
	public HourOutputFormatter(int hours) {
		CURRENT_HOURS = hours;
	}

	public String buildHoursRows() {
		return formatOutput(getHoursUpperLamps(),getHoursLowerLamps());
	}

	private String formatOutput(int uppperLamps, int lowerLamps) {
		for(int i = 0; i < uppperLamps; i++) {
			UPPER_LAMPS_ROW.replace(i, i+1, "R");
		}
		
		for(int i = 0; i < lowerLamps; i++) {
			LOWER_LAMPS_ROW.replace(i, i+1, "R");
		}
		return UPPER_LAMPS_ROW + "\n" + LOWER_LAMPS_ROW + "\n";
	}

	public int getHoursLowerLamps() {
		if (CURRENT_HOURS < UPPER_LAMP_VALUE)
		{
			return CURRENT_HOURS;
		}else
		{
			return CURRENT_HOURS % UPPER_LAMP_VALUE;
		}
	}

	public int getHoursUpperLamps() {
		if(CURRENT_HOURS < UPPER_LAMP_VALUE)
			return 0;
		else 
			return CURRENT_HOURS / UPPER_LAMP_VALUE;
	}
}
