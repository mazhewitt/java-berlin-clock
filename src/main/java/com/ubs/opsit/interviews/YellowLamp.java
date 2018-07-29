package com.ubs.opsit.interviews;

public class YellowLamp extends Lamp {

	private final char dispayOnIndicator = 'Y';
	private int unitTime;

	public YellowLamp(int unitTime) {
		this.unitTime = unitTime;
	}

	@Override
	public char getDispayOnIndicator() {
		return dispayOnIndicator;
	}

}
