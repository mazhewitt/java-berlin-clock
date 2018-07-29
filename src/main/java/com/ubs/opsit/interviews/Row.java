package com.ubs.opsit.interviews;

import java.util.List;

public interface Row {
	void setTime(String time);
	
	default String display() {
		StringBuilder time = new StringBuilder();
		for (Lamp lamp : getLamps()) {
			time.append(lamp.display());			
		}
		return time.toString();
	}
	
	List<Lamp> getLamps();
	
}
