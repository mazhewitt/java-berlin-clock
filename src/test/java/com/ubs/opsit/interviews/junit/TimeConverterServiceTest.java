package com.ubs.opsit.interviews.junit;

import com.ubs.opsit.interviews.TimeConverterService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sam on 23/6/17.
 */
public class TimeConverterServiceTest {

    TimeConverterService timeConverterService = new TimeConverterService();

    @Test
    public void testGetHour(){
        String hourFifteen= "RRRO"+"\n"+"OOOO";
        String hourSixteen= "RRRO"+"\n"+"ROOO";
        String hourZero= "OOOO"+"\n"+"OOOO";
        String hourTwentyFour= "RRRR"+"\n"+"RRRR";
        Assert.assertEquals(hourFifteen,timeConverterService.getHour(15));
        Assert.assertEquals(hourSixteen,timeConverterService.getHour(16));
        Assert.assertEquals(hourZero,timeConverterService.getHour(0));
        Assert.assertEquals(hourTwentyFour,timeConverterService.getHour(24));
    }

    @Test
    public void testGetSecond(){
        String secondThree= "O";
        String secondZero= "Y";
        String secondFiftyNine= "O";
        Assert.assertEquals(secondThree,timeConverterService.getSecond(3));
        Assert.assertEquals(secondZero,timeConverterService.getSecond(0));
        Assert.assertEquals(secondFiftyNine,timeConverterService.getSecond(59));
    }

    @Test
    public void testGetMinutes(){
        String minutesSixteen ="YYROOOOOOOO"+"\n"+"YOOO";
        String minutesFifteen ="YYROOOOOOOO"+"\n"+"OOOO";
        String minutesZero ="OOOOOOOOOOO"+"\n"+"OOOO";
        String minutesFiftyNine ="YYRYYRYYRYY"+"\n"+"YYYY";
        Assert.assertEquals(minutesSixteen,timeConverterService.getMinute(16));
        Assert.assertEquals(minutesFifteen,timeConverterService.getMinute(15));
        Assert.assertEquals(minutesZero,timeConverterService.getMinute(0));
        Assert.assertEquals(minutesFiftyNine,timeConverterService.getMinute(59));
    }

    @Test
    public void testBerlinTime(){
        String berlinTime1="Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
        Assert.assertEquals(berlinTime1,timeConverterService.convertToBerlinTime("00:00:00"));
        String berlinTime2="Y\nRROO\nRRRO\nYYROOOOOOOO\nOOOO";
        Assert.assertEquals(berlinTime2, timeConverterService.convertToBerlinTime("13:15:00"));
        try {
            timeConverterService.convertToBerlinTime("24:01:00");
        }catch(RuntimeException ex){
            Assert.assertEquals(ex.getMessage(),"Incorrect time for conversion");
        }
    }
}
