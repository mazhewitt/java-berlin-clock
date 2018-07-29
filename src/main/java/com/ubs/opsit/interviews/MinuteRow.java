package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MinuteRow implements Row {

	private Function<String, Integer> converter;

	private List<Lamp> lamps = new ArrayList<>();

	public MinuteRow(Function<String, Integer> converter) {
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

	public List<Lamp> getLamps() {
		return lamps;
	}

}
