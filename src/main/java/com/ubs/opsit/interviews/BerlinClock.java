/**
 * 
 */
package com.ubs.opsit.interviews;

/**
 * @author Aniket D
 *
 */
public class BerlinClock implements TimeConverter {

	/* (non-Javadoc)
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 */
	@Override
	public String convertTime(String aTime) {
		System.out.println(aTime);
		
		String timeSlice[]= aTime.split(":");
		String seconds = (Integer.valueOf(timeSlice[2]).intValue()%2 == 0) ? "Y\r\n" : "O\r\n";
		StringBuffer berlinTimeRepresentation = new StringBuffer(seconds);
		berlinTimeRepresentation.append(getHourRepresentation(timeSlice[0]));
		berlinTimeRepresentation.append(getMinutesRepresentation(timeSlice[1]));
		
//		if(aTime.equals("24:00:00")){
//			return "Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO";
//		}else if(aTime.equals("23:59:59")){
//			return "O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY";
//		}else if(aTime.equals("13:17:01")){
//			return "O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO";
//		}else {
//			return "Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO";
//		}
		
		return berlinTimeRepresentation.toString();
	}

	private String getMinutesRepresentation(String minutesStr) {
		int minutes = Integer.valueOf(minutesStr).intValue();
		StringBuffer minutesRepresentation = new StringBuffer("");
		
		for(int count = 1; count <= minutes/5; count++){
			if(count == 3 || count == 6 || count == 9){
				minutesRepresentation.append("R");
			}else {
				minutesRepresentation.append("Y");
			}
		}
		for(int j=1;j <= 11 - (minutes/5);j++){
			minutesRepresentation.append("O");
		}
		minutesRepresentation.append("\r\n");
		
		if(minutes%5 == 1){
			minutesRepresentation.append("YOOO");
		}else if(minutes%5 == 2){
			minutesRepresentation.append("YYOO");
		}else if(minutes%5 == 3){
			minutesRepresentation.append("YYYO");
		}else if(minutes%5 == 4){
			minutesRepresentation.append("YYYY");
		}else if(minutes%5 == 0){
			minutesRepresentation.append("OOOO");
		}
		return minutesRepresentation.toString();
	}

	private String getHourRepresentation(String hourStr) {
		int hour = Integer.valueOf(hourStr).intValue();
		String hourRepresentation = "";
		if(hour>=20){
			hourRepresentation = "RRRR\r\n";
		}else if(hour>=15){
			hourRepresentation = "RRRO\r\n";
		}else if(hour>=10){
			hourRepresentation = "RROO\r\n";
		}else if(hour>= 5){
			hourRepresentation = "ROOO\r\n";
		}else {
			hourRepresentation = "OOOO\r\n";
		}
		
		if(hour%5 == 1){
			hourRepresentation = hourRepresentation + "ROOO\r\n";
		}else if(hour%5 == 2){
			hourRepresentation = hourRepresentation + "RROO\r\n";
		}else if(hour%5 == 3){
			hourRepresentation = hourRepresentation + "RRRO\r\n";
		}else if(hour%5 == 4){
			hourRepresentation = hourRepresentation + "RRRR\r\n";
		}else if(hour%5 == 0){
			hourRepresentation = hourRepresentation + "OOOO\r\n";
		}
		return hourRepresentation;
	}

}
