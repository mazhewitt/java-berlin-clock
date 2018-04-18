package com.ubs.opsit.interviews;

public enum LampsRow {
	HOURS_UPPER(4) ,
	HOURS_LOWER(4) ,
	MINUTES_UPPER(11) ,
	MINUTES_LOWER(4) ;
	
	private final int value;
	public int getValue() {
		return value;
	}
	
	private LampsRow(int value) {
		this.value = value;
	}

}
