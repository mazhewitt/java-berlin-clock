package com.ubs.opsit.interviews;
/*Client which takes time in 24 hour format and converts into Berlin Clock convention/format
If client wants, client can create other converter and put conversion login in convertTime method */
public class ClientApp {
	public static void main(String[] args) {
		TimeConverter converter = new BerlinClockConverter();		
		String convertedTime = converter.convertTime(null);
		if(convertedTime.length()>0)
			System.out.println("Given Time in Berlin Clock:\n"+convertedTime);		
	}

}
