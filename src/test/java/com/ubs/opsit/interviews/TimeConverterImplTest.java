package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeConverterImplTest {

    private final TimeConverter converter = new TimeConverterImpl();

    @Test(expected = IllegalArgumentException.class)
    public void testNullTime() {
        converter.convertTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTime() {
        converter.convertTime("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFormatTime() {
        converter.convertTime("4 PM");
    }
}