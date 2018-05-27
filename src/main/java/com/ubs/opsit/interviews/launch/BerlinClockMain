package com.ubs.opsit.interviews.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.TimeConverterImpl;

public class BerlinClockMain {
	
	public static void main(String args[]) {
		
		System.out.println("Welcome to the Berlin Clock Time converter");
		System.out.println("Enter the time in hh:mm:ss format");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String time = reader.readLine();
			System.out.println("time is:: "+ time);
			
			TimeConverter timeConverter = new TimeConverterImpl();
			String[] result = timeConverter.convertTime(time);
			System.out.println("Time in Berlin Clock format is: ");
			for(int i =0;i<result.length;i++) {
				System.out.println(result[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
