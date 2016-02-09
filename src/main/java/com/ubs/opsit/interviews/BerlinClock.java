package com.ubs.opsit.interviews;

public class BerlinClock {
	private String secondRow;
	private String hoursTopRow;
	private String hoursBottomRow;
	private String minutesTopRow;
	private String minutesBottomRow;
	
	public BerlinClock(String secondRow, String hoursTopRow, String hoursBottomRow, String minutesTopRow, String minutesBottomRow) {
		this.secondRow = secondRow;
		this.hoursTopRow = hoursTopRow;
		this.hoursBottomRow = hoursBottomRow;
		this.minutesTopRow = minutesTopRow;
		this.minutesBottomRow = minutesBottomRow;
	}
	
	public String getSecondRow() {
		return secondRow;
	}

	public String getHoursTopRow() {
		return hoursTopRow;
	}

	public String getHoursBottomRow() {
		return hoursBottomRow;
	}

	public String getMinutesTopRow() {
		return minutesTopRow;
	}

	public String getMinutesBottomRow() {
		return minutesBottomRow;
	}

	@Override
	public String toString() {
		return getSecondRow() + System.lineSeparator() + 
				getHoursTopRow() + System.lineSeparator() + 
				getHoursBottomRow() + System.lineSeparator() + 
				getMinutesTopRow() + System.lineSeparator() + 
				getMinutesBottomRow();
	}
}
