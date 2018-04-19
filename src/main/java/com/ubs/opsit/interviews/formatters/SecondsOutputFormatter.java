package com.ubs.opsit.interviews.formatters;

public class SecondsOutputFormatter {
	
	private int CURRENT_SECONDS;

	public SecondsOutputFormatter(int seconds) {
		CURRENT_SECONDS = seconds;
	}

	public int getSecondsOutput() {
		if(CURRENT_SECONDS % 2 == 0)
		{
			return 1;
		}
			return 0;
	}

	public String buildSecondsRow() {
		if(getSecondsOutput() == 0)
			return "O\n";
		else
			return "Y\n";
	}

}
