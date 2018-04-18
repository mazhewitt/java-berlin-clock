package com.ubs.opsit.interviews;

public class FinalOutputBuilder {

	private static int HOURS ;
	private static int MINUTES;
	private static int SECONDS;
	
	
	public FinalOutputBuilder(String aTime) {
		String [] arr = aTime.split(":");
		HOURS = Integer.parseInt(arr[0]);
		MINUTES = Integer.parseInt(arr[1]);
		SECONDS = Integer.parseInt(arr[2]);
	}
	
	public String getFinalOutput() {
		return buildSecondsRow() 
				+ new HourOutputFormatter(HOURS).buildHoursRows() 
				+ buildMinutesRows(); 
				/*"Y\n" + 
				"OOOO\n" + 
				"OOOO\n" + 
				"OOOOOOOOOOO\n" + 
				"OOOO";*/
	}

	private String buildSecondsRow() {
		// TODO Auto-generated method stub
		return "";
	}

	private String buildMinutesRows() {
		// TODO Auto-generated method stub
		return "";
	}


}
