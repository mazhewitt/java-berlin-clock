package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		
		return new FinalOutputBuilder(aTime).getFinalOutput();
		
	}

}
