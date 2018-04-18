package com.ubs.opsit.interviews;

public class HourOutputFormatter {
	
	private static int CURRENT_HOURS;
	
	public HourOutputFormatter(int hours) {
		CURRENT_HOURS = hours;
	}

	public String buildHoursRows() {
		int uppperLamps = getHoursUpperLamps();
		int lowerLamps = getHoursLowerLamps();
		return formatOutput(uppperLamps,lowerLamps);
	}

	private String formatOutput(int uppperLamps, int lowerLamps) {
		String upperLampsOutput = "";
		for(int i = 0; i < uppperLamps; i++) {
			upperLampsOutput = upperLampsOutput + "Y";
		}
		
		String lowerLampsOutput = "";
		for(int i = 0; i < lowerLamps; i++) {
			lowerLampsOutput = lowerLampsOutput + "Y";
		}
		return upperLampsOutput + "\n" + lowerLampsOutput + "\n";
	}

	public int getHoursLowerLamps() {
		return CURRENT_HOURS / (LampsRow.HOURS_LOWER.getValue() + 1);
	}

	public int getHoursUpperLamps() {
		if(CURRENT_HOURS < (LampsRow.HOURS_UPPER.getValue() + 1))
			return 0;
		else 
			return CURRENT_HOURS / (LampsRow.HOURS_UPPER.getValue() + 1);
	}
}
