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

    @Test
    public void testConvertTime1() throws Exception {
        assertEquals("Y\n" +
                "OOOO\n" +
                "OOOO\n" +
                "OOOOOOOOOOO\n" +
                "OOOO", converter.convertTime("00:00:00"));
    }

    @Test
    public void testConvertTime2() throws Exception {
        assertEquals("O\n" +
                "RROO\n" +
                "RRRO\n" +
                "YYROOOOOOOO\n" +
                "YYOO", converter.convertTime("13:17:01"));
    }

    @Test
    public void testConvertTime3() throws Exception {
        assertEquals("O\n" +
                "RRRR\n" +
                "RRRO\n" +
                "YYRYYRYYRYY\n" +
                "YYYY", converter.convertTime("23:59:59"));
    }

    @Test
    public void testConvertTime4() throws Exception {
        assertEquals("Y\n" +
                "RRRR\n" +
                "RRRR\n" +
                "OOOOOOOOOOO\n" +
                "OOOO", converter.convertTime("24:00:00"));
    }
}