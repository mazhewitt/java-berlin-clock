package com.ubs.opsit.interviews;

/**
 * Created by Sameh on 30/01/2016.
 */
public class BerlinClockTimeConverter implements TimeConverter {

    private static final String TIME_PATTERN_24 = "([01]{1}[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";
    private static final String TIME_SEPARATOR = ":";
    private static final String OFF = "O";
    private static final String RED = "R";
    private static final String YELLOW = "Y";

    // system-dependent line separator string
    private static final String LINE_SEPARATOR = System.lineSeparator();
    // First light is on every 2 seconds
    private static final int SECONDS_INTERVAL = 2;
    // used for modulus operator
    private static final int REMAINDER = 0;
    // How many hours each lamp in first row represents
    private static final int LAMP_HOURS_FIRST_ROW = 5;
    // Number of lamps in first row (hours)
    private static final int LAMPS_FIRST_ROW = 4;
    // Number of lamps in second row (hours)
    private static final int LAMPS_SECOND_ROW = 4;
    // number of minutes represented by each lamp in first minutes row
    private static final int MINUTES_FIRST_ROW_SIZE = 5;
    // the interval indicating the first quarter, second quarter, etc where the lamp is red
    private static final int MINUTES_RED_INTERVAL = 3;
    // number of lamps in first row (minutes)
    private static final int MINUTES_FIRST_ROW_COUNT = 11;
    // number of lamps in second minutes row
    private static final int MINUTES_SECOND_ROW_COUNT = 4;

    private StringBuilder timeResult;

    private int seconds;
    private int minutes;
    private int hours;


    @Override
    public String convertTime(String aTime){
        parseTime(aTime);
        timeResult = new StringBuilder();
        resolveSeconds();
        resolveHours();
        resolveMinutes();
        return timeResult.toString();
    }

    public void parseTime(String aTime){

        if(aTime==null || !aTime.matches(TIME_PATTERN_24)){
            throw new IllegalArgumentException();
        }
        String timeArray[]= aTime.split(TIME_SEPARATOR);
        this.seconds = Integer.valueOf(timeArray[2]);
        this.minutes = Integer.valueOf(timeArray[1]);
        this.hours = Integer.valueOf(timeArray[0]);
    }

    public void resolveSeconds(){

        if((this.seconds % SECONDS_INTERVAL) == REMAINDER){
            timeResult.append(YELLOW);
        }else{
            timeResult.append(OFF);
        }
        timeResult.append(LINE_SEPARATOR);
    }

    public void resolveHours(){

        int firstRow = this.hours / LAMP_HOURS_FIRST_ROW ;
        int secondeRow = this.hours % LAMP_HOURS_FIRST_ROW ;

        for(int i=0; i < firstRow; i++){
            timeResult.append(RED);
        }

        for(int i=firstRow; i < LAMPS_FIRST_ROW; i++){
            timeResult.append(OFF);
        }

        timeResult.append(LINE_SEPARATOR);

        for(int i=0; i < secondeRow; i++){
            timeResult.append(RED);
        }

        for(int i=secondeRow; i < LAMPS_SECOND_ROW; i++){
            timeResult.append(OFF);
        }

        timeResult.append(LINE_SEPARATOR);
    }
    public void resolveMinutes(){

        int firstRowMinutes = this.minutes / MINUTES_FIRST_ROW_SIZE;
        int secondRowMinutes = this.minutes % MINUTES_FIRST_ROW_SIZE;

        for(int i=1; i <= firstRowMinutes; i++){

            if( (i % MINUTES_RED_INTERVAL) ==0 ){
                timeResult.append(RED);
            }else{
                timeResult.append(YELLOW);
            }

        }

        for(int i=firstRowMinutes; i < MINUTES_FIRST_ROW_COUNT ; i++){
            timeResult.append(OFF);
        }

        timeResult.append(LINE_SEPARATOR);

        for(int i=0; i < secondRowMinutes; i++){
            timeResult.append(YELLOW);
        }

        for(int i=secondRowMinutes; i < MINUTES_SECOND_ROW_COUNT; i++){
            timeResult.append(OFF);
        }
    }
}
