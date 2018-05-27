package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.constant.ConstantsFile;

public class TimeConverterImpl implements TimeConverter{
	
	public String[] convertTime(String aTime) {
		
		List<Integer> timeParts = new ArrayList<Integer>();
        for (String timePart : aTime.split(":")) {
        	timeParts.add(Integer.parseInt(timePart));
        }
        
        String seconds = calculateSeconds(timeParts.get(2));
        String hours = calculateTopHours(timeParts.get(0));
        String topHours = calculateBottomHours(timeParts.get(0));
        String topMin = calculateTopMinutes(timeParts.get(1));
        String minutes = calculateBottomMinutes(timeParts.get(1));
        
        String[] finalOutput = new String[] {seconds, hours, topHours, topMin,minutes};        
 		
		return finalOutput;
	}

	public String calculateBottomMinutes(int bottomMinutes) {
		return getDisplayData(4, bottomMinutes % 5, ConstantsFile.YellowIndicator);
		
	}

	public String calculateTopMinutes(int topMinutes) {
		return getDisplayData(11, getTopSigns(topMinutes), ConstantsFile.YellowIndicator).replaceAll("YYY", "YYR");
		
	}

	public String calculateBottomHours(int bottomHours) {
		return getDisplayData(4, bottomHours % 5);
		
	}

	public String calculateTopHours(int topHours) {
		return getDisplayData(4, getTopSigns(topHours));
		
	}
	
	public String calculateSeconds(int seconds) {
		if (seconds % 2 == 0) return ConstantsFile.YellowIndicator;
        else return ConstantsFile.OffIndicator;
	}

	private int getTopSigns(int topHours) {
		return (topHours - (topHours % 5)) / 5;
	}

	private String getDisplayData(int lamps, int onSigns) {
        return getDisplayData(lamps, onSigns, ConstantsFile.RedIndicator);
    }
	
	private String getDisplayData(int lamps, int onSigns, String onSign) {
        String output = "";
        for (int i = 0; i < onSigns; i++) {
        	output += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
        	output += ConstantsFile.OffIndicator;
        }
        return output;
    }
	

}
