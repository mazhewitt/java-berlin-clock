package com.ubs.opsit.interviews;

import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import org.slf4j.Logger;


public class BerlinClock
    implements TimeConverter
{
    static final String         ALTERNATIVE_MIDNIGHT_FORMAT = "24:00:00";
    private static final Logger LOG                         = LoggerFactory.getLogger( BerlinClock.class );


    enum LampStatus
    {
        OFF( "O" ), YELLOW( "Y" ), RED( "R" );

        private String status;


        LampStatus( String status )
        {
            this.status = status;
        }

        public String toString()
        {
            return this.status;
        }
    }


    @Override
    public String convertTime( String aTime )
    {
        final int HOURS_SUBDIVISION = 5;
        final int MINUTES_SUBDIVISION = 5;

        LocalTime time = validateInputString( aTime );

        int seconds = time.getSecond();
        boolean lampSecondsToggle = (seconds % 2 == 0);

        int hour = (aTime.equals( ALTERNATIVE_MIDNIGHT_FORMAT ) ? 24 : time.getHour()); // special case for midnight
        int lampsLitTopRowHours = hour / HOURS_SUBDIVISION;
        int lampsLitBottomRowHours = hour % HOURS_SUBDIVISION;

        int minutes = time.getMinute();
        int lampsLitTopRowMinutes = minutes / MINUTES_SUBDIVISION;
        int lampsLitBottomRowMinutes = minutes % MINUTES_SUBDIVISION;

        return timeToString( lampSecondsToggle, lampsLitTopRowHours, lampsLitBottomRowHours, lampsLitTopRowMinutes, lampsLitBottomRowMinutes );
    }

    /**
     * Validates whether the input can be parsed as a LocalTime and returns it as such.
     * We are using the @code{ResolverStyle.SMART} to allow the 24:00:00 syntax for midnight.
     *
     * @param aTime to be validated
     * @return the local time, not null
     * @throws NullPointerException if input is null
     * @throws DateTimeParseException if input can not be parsed successfully
     */
    public LocalTime validateInputString( String aTime )
    {
        try {
            return LocalTime.parse( aTime, DateTimeFormatter.ISO_LOCAL_TIME.withResolverStyle( ResolverStyle.SMART ) );
        } catch ( RuntimeException e ) {
            LOG.error( aTime + " can not be parsed: " + e.getMessage() );
            throw e;
        }
    }

    private String timeToString( boolean secondsToggle, int lampsLitTopRowHours, int lampsLitBottomRowHours, int lampsLitTopRowMinutes, int lampsLitBottomRowMinutes )
    {
        StringBuilder berlinTime = new StringBuilder( 24 + 4 * System.lineSeparator().length() ); // 24 is the total number of lamps + 4 new line characters

        berlinTime.append( secondsToggle ? LampStatus.YELLOW.toString() : LampStatus.OFF.toString() ).append( System.lineSeparator() );
        appendDefaultRow( berlinTime, lampsLitTopRowHours, LampStatus.RED.toString() ).append( System.lineSeparator() );
        appendDefaultRow( berlinTime, lampsLitBottomRowHours, LampStatus.RED.toString() ).append( System.lineSeparator() );
        appendTopRowMinutes( berlinTime, lampsLitTopRowMinutes ).append( System.lineSeparator() );
        appendDefaultRow( berlinTime, lampsLitBottomRowMinutes, LampStatus.YELLOW.toString() );

        return berlinTime.toString();
    }

    private StringBuilder appendDefaultRow( StringBuilder berlinTime, int lampsLit, String blinkColor )
    {
        for ( int i = 0; i < 4; i++ ) {
            berlinTime.append( (i < lampsLit) ? blinkColor : LampStatus.OFF.toString() );
        }
        return berlinTime;
    }

    private StringBuilder appendTopRowMinutes( StringBuilder berlinTime, int lampsLit )
    {
        for ( int i = 0; i < 11; i++ ) {
            if ( i < lampsLit ) {
                berlinTime.append( ((i + 1) % 3 == 0) ? LampStatus.RED.toString() : LampStatus.YELLOW.toString() ); // every third lamp needs to be red
            } else {
                berlinTime.append( LampStatus.OFF.toString() );
            }
        }

        return berlinTime;
    }
}
