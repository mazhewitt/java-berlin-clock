package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sam on 23/6/17.
 */
public class TimeConverterImpl implements TimeConverter{

    private final static Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);

    private TimeConverterService timeConverterService=new TimeConverterService();

    @Override
    public String convertTime(String aTime) {
        LOG.info("[TimeConverterImpl] Converting time {}", aTime);
        //Added an extra service layer to allow any preconversion of time format
        return timeConverterService.convertToBerlinTime(aTime);
    }


}
