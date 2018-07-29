package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SecondsRow implements Row {

	private Function<String, Integer> converter;

	private List<Lamp> lamps = new ArrayList<>();

	public SecondsRow(Function<String, Integer> converter) {
		this.converter = converter;
	}

	@Override
	public void setTime(String time) {
		int seconds = converter.apply(time);
		if (seconds % 2 == 0) {
			lamps.get(0).switchOn();
		} else {
			lamps.get(0).switchOff();
		}

	}

	public List<Lamp> getLamps() {
		return lamps;
	}

}
