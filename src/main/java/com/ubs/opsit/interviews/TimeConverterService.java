package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.constants.BerlinClockConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sam on 23/6/17.
 */
public class TimeConverterService {
    private final static Logger LOG = LoggerFactory.getLogger(TimeConverterService.class);

    private static final String ROW_HOUR = "OOOO";
    private static final String ROW_MINUTES_TOP = "OOOOOOOOOOO";
    private static final String ROW_MINUTES_BOTTOM = "OOOO";
    private final static String NEW_LINE = "\n";

    /**
     * Returns Berlin time for the hh:mm:ss format
     * @param aTime
     * @return
     */
    public String convertToBerlinTime(String aTime){
        if(StringUtils.isBlank(aTime)){
            throw new RuntimeException("Timestamp that was passed to service was Blank,null or empty");
        }
        String timeArray[]=aTime.split(":");
        if(timeArray.length!=3){
            throw new RuntimeException("Incorrect Time format");
        }
        //Check that the clock doesnt cross 24 hrs
        if(Integer.parseInt(timeArray[0])==24 && (Integer.parseInt(timeArray[2])>0 || Integer.parseInt(timeArray[1]) >0))
            throw new RuntimeException("Incorrect time for conversion");
        return getSecond(Integer.parseInt(timeArray[2]))+NEW_LINE+getHour(Integer.parseInt(timeArray[0]))+NEW_LINE+getMinute(Integer.parseInt(timeArray[1]));
    }

    /**
     * Returns the hour pattern of the Berlin Clock
     *
     * @param hour
     * @return
     */
    public String getHour(int hour) {
        if(hour>24 || hour < 0 ) {
            throw new RuntimeException("Incorrect Hour!! hour >"+ hour );
        }
        String hourPattern;
        StringBuilder indicatorHourTop=new StringBuilder();
        StringBuilder indicatorHourBottom=new StringBuilder();
        for(int i=0;i<hour/5;i++){
            indicatorHourTop.append(BerlinClockConstants.LAMP_ON_HOUR);
        }
        hourPattern=indicatorHourTop + ROW_HOUR.substring(indicatorHourTop.length())+NEW_LINE;
        for(int i=0;i<hour%5;i++){
            indicatorHourBottom.append(BerlinClockConstants.LAMP_ON_HOUR);
        }
        hourPattern=hourPattern+indicatorHourBottom + ROW_HOUR.substring(indicatorHourBottom.length());
        return hourPattern;
    }

    /**
     * Returns the minute pattern of the Berlin Clock
     * @param minute
     * @return
     */
    public String getMinute(int minute) {
        if(minute >59 || minute <0 ){
            throw new RuntimeException("Incorrect minute!! minute >"+ minute );
        }
        String minutePattern;
        StringBuilder indicatorMinuteTop=new StringBuilder();
        StringBuilder indicatorMinuteBottom=new StringBuilder();
        for(int i=0;i<minute/5;i++){
            if((i+1)%3 ==0)
                indicatorMinuteTop.append(BerlinClockConstants.LAMP_ON_MIN_QUARTER);
            else
                indicatorMinuteTop.append(BerlinClockConstants.LAMP_ON_MIN);
        }
        minutePattern=indicatorMinuteTop + ROW_MINUTES_TOP.substring(indicatorMinuteTop.length())+NEW_LINE;
        for(int i=0;i<minute%5;i++){
            indicatorMinuteBottom.append(BerlinClockConstants.LAMP_ON_MIN);
        }
        minutePattern=minutePattern+indicatorMinuteBottom + ROW_MINUTES_BOTTOM.substring(indicatorMinuteBottom.length());
        return minutePattern;
    }

    /**
     * Returns the second pattern of the Berlin Clock
     * @param second
     * @return
     */
    public String getSecond(int second) {
        if(second >59 || second <0 ){
            throw new RuntimeException("Incorrect second!! second >"+ second );
        }
        return second%2 == 0 ? BerlinClockConstants.LAMP_ON_SECOND:
                BerlinClockConstants.LAMP_OFF_SECOND;
    }

}
