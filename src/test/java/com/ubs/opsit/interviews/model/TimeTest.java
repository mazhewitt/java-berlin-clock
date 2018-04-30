package com.ubs.opsit.interviews.model;

import org.junit.Assert;
import org.junit.Test;

public class TimeTest {

    @Test
    public void testValidTime(){
        Time time = new Time(23, 16, 50);
        Assert.assertEquals(time.getHour(), 23);
        Assert.assertEquals(time.getMinutes(), 16);
        Assert.assertEquals(time.getSeconds(), 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHours(){
        new Time(27, 16, 00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMinutes(){
        new Time(23, 75, 00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSeconds(){
        new Time(23, 45, 70);
    }
}
