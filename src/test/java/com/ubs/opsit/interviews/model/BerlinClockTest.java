package com.ubs.opsit.interviews.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {


    @Test
    public void testCreateBerlinClockWithDefaultValues(){
        BerlinClock berlinClock = new BerlinClock();
        Assert.assertTrue(berlinClock.getSecondsLamp().isOn());
        Assert.assertTrue(berlinClock.getSecondsLamp().getColor() == Color.YELLOW);
        Assert.assertTrue(berlinClock.getFiveHoursRow().getLamps().size() == 4);
        Assert.assertTrue(berlinClock.getOneHourRow().getLamps().size() == 4);
        Assert.assertTrue(berlinClock.getFiveMinutesRow().getLamps().size() == 11);
        Assert.assertTrue(berlinClock.getOneMinuteRow().getLamps().size() == 4);
    }


    @Test
    public void testSecondsLampBeOnForEvenSeconds() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setSeconds(2);
        assertEquals("Y", berlinClock.getSecondsLamp().toString());
    }

    @Test
    public void testSecondsLampBeOffForOddSeconds() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setSeconds(33);
        assertEquals("O", berlinClock.getSecondsLamp().toString());
    }

    @Test
    public void testFiveHoursRowDisplayCorrectlyForGivenHours() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setHours(15);

        assertEquals("RRRO", berlinClock.getFiveHoursRow().toString());
    }

    @Test
    public void testOneHoursRowDisplayCorrectlyForGivenHours() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setHours(2);

        assertEquals("RROO", berlinClock.getOneHourRow().toString());
    }

    @Test
    public void testFiveMinutesRowDisplayCorrectlyForGivenMinutes() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setMinutes(20);

        assertEquals("YYRYOOOOOOO", berlinClock.getFiveMinutesRow().toString());
    }

    @Test
    public void testOneMinutesRowDisplayCorrectlyForGivenMinutes() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setMinutes(2);

        assertEquals("YYOO", berlinClock.getOneMinuteRow().toString());
    }

    @Test
    public void testThreeOclock() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setHours(3);

        assertEquals("RRRO", berlinClock.getOneHourRow().toString());
    }
    @Test
    public void testElevenOclock() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setHours(11);

        assertEquals("RROO", berlinClock.getFiveHoursRow().toString());
        assertEquals("ROOO", berlinClock.getOneHourRow().toString());
    }

    @Test
    public void testAQuarterPastNine() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setHours(9).setMinutes(15);

        assertEquals("ROOO", berlinClock.getFiveHoursRow().toString());
        assertEquals("RRRR", berlinClock.getOneHourRow().toString());
        assertEquals("YYROOOOOOOO", berlinClock.getFiveMinutesRow().toString());
    }
}
