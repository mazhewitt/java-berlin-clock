package com.ubs.opsit.interviews;

import org.junit.Test;

import java.time.format.DateTimeParseException;

public class TimeConverterImplTest {

    private final TimeConverter converter = new TimeConverterImpl();

    @Test(expected = NullPointerException.class)
    public void testNullTime() {
        converter.convertTime(null);
    }

    @Test(expected = DateTimeParseException.class)
    public void testEmptyTime() {
        converter.convertTime("");
    }

    @Test(expected = DateTimeParseException.class)
    public void testIllegalFormatTime() {
        converter.convertTime("4 PM");
    }
}