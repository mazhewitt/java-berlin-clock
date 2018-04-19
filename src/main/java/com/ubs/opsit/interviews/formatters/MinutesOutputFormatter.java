package com.ubs.opsit.interviews.formatters;

public class MinutesOutputFormatter {
	
	private int CURRENT_MINUTES;
	private int UPPER_LAMP_VALUE = 5;
	private StringBuilder UPPER_LAMP_ROW = new StringBuilder("OOOOOOOOOOO");
	private StringBuilder LOWER_LAMP_ROW = new StringBuilder("OOOO");
	
	public MinutesOutputFormatter(int minutes) {
		CURRENT_MINUTES = minutes;
	}
	

	public int getMinutesUperRow() {
		if(CURRENT_MINUTES < UPPER_LAMP_VALUE)
		{
			return 0;
		}else
		{
			return CURRENT_MINUTES/UPPER_LAMP_VALUE;
		}
	}


	public int getMinutesLowerRow() {
		if(CURRENT_MINUTES < UPPER_LAMP_VALUE)
		{
			return CURRENT_MINUTES;
		}else
		{
			return CURRENT_MINUTES % UPPER_LAMP_VALUE;
		}
	}


	public String buildMinutesRows() {
		return formatOutput(getMinutesUperRow(), getMinutesLowerRow());
	}


	private String formatOutput(int minutesUperRow, int minutesLowerRow) {
		for(int i = 0; i < minutesUperRow; i++) {
			if((i+1) % 3 == 0)
			{
				UPPER_LAMP_ROW.replace(i, i+1, "R");
			}else
			{
				UPPER_LAMP_ROW.replace(i, i+1, "Y");
			}
		}
		
		for (int i = 0 ; i < minutesLowerRow ; i++) {
			LOWER_LAMP_ROW.replace(i, i+1, "Y");
		}
		return UPPER_LAMP_ROW + "\n" + LOWER_LAMP_ROW ;
	}

}
