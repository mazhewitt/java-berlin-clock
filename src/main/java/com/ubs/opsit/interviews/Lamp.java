package com.ubs.opsit.interviews;

public abstract class Lamp {
	final char dispayOffIndicator = 'O';

	private boolean onOffIndicator;

	public char getDispayOffIndicator() {
		return dispayOffIndicator;
	}

	public char display() {
		if (onOffIndicator) {
			return getDispayOnIndicator();
		} else {
			return getDispayOffIndicator();
		}
	}

	public void switchOn() {
		onOffIndicator = true;
	}

	public void switchOff() {
		onOffIndicator = false;
	}

	public abstract char getDispayOnIndicator();
}
