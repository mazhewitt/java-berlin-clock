package com.ubs.opsit.interviews;

public class RedLamp extends Lamp {

	private int unitTime;

	public RedLamp(int unitTime) {
		this.unitTime = unitTime;
	}

	private final char dispayOnIndicator = 'R';

	@Override
	public char getDispayOnIndicator() {
		return dispayOnIndicator;
	}

}
