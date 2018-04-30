package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

public class BerlinClockTimeConverterTest {

    @Test
    public void testMidNight(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        Assert.assertEquals("Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO",berlinClockTimeConverter.convertTime("00:00:00"));
    }

    @Test
    public void testMiddleOfAfternoon(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        Assert.assertEquals("O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO",berlinClockTimeConverter.convertTime("13:17:01"));
    }

    @Test
    public void testJustBeforeMidnight(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        Assert.assertEquals("O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY",berlinClockTimeConverter.convertTime("23:59:59"));
    }

    @Test
    public void testMidNightWith24Hour(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        Assert.assertEquals("Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO",berlinClockTimeConverter.convertTime("24:00:00"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTimeWithNull(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        berlinClockTimeConverter.convertTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTimeWithEmptyString(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        berlinClockTimeConverter.convertTime("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTimeWithWrongFormat(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        berlinClockTimeConverter.convertTime("wrongtime");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHours(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        berlinClockTimeConverter.convertTime("27:16:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMinutes(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        berlinClockTimeConverter.convertTime("23:75:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSeconds(){
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter();
        berlinClockTimeConverter.convertTime("23:45:70");
    }
}
