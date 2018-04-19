package com.ubs.opsit.interviews.formatters;



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
	
	public String getOutput() {
		return null;
	}
	
	public String getFinalOutput() {
		return 
				new SecondsOutputFormatter(SECONDS).buildSecondsRow() 
				+ new HourOutputFormatter(HOURS).buildHoursRows() 
				+ new MinutesOutputFormatter(MINUTES).buildMinutesRows();
	}
}
