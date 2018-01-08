package com.ubs.opsit.interviews;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;


public class BerlinClockUnitTests
{
    private BerlinClock berlinClock = new BerlinClock();


    @Test( expected = NullPointerException.class )
    public void testNullInputString()
    {
        berlinClock.validateInputString( null );
    }

    @Test( expected = DateTimeParseException.class )
    public void testEmptyInputString()
    {
        berlinClock.validateInputString( "" );
    }

    @Test( expected = DateTimeParseException.class )
    public void testInvalidFormatInputString()
    {
        berlinClock.validateInputString( "1:1:1" );
    }

    @Test( expected = DateTimeParseException.class )
    public void testInvalidInputStringRange()
    {
        berlinClock.validateInputString( "24:01:01" );
    }

    @Test
    public void testLocalTimeFormatIsAccepted()
    {
        assertThat( berlinClock.validateInputString( LocalTime.now().toString() ), instanceOf( LocalTime.class ) );
    }

    @Test
    public void test24HoursAreAccepted()
    {
        berlinClock.validateInputString( "24:00:00" );
    }
}
