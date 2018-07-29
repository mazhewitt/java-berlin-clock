package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HourRow implements Row {

	private List<Lamp> lamps = new ArrayList<>();

	private Function<String, Integer> converter;

	public HourRow(Function<String, Integer> converter) {
		this.converter = converter;
	}

	@Override
	public void setTime(String time) {
		int noOfLamps = converter.apply(time);
		for (Lamp lamp : lamps.subList(0, noOfLamps)) {
			lamp.switchOn();
		}
		for (Lamp lamp : lamps.subList(noOfLamps, lamps.size())) {
			lamp.switchOff();
		}
	}

	@Override
	public List<Lamp> getLamps() {
		return lamps;
	}

}
