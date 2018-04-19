package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.formatters.FinalOutputBuilder;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		
		return new FinalOutputBuilder(aTime).getFinalOutput();
		
	}

}
