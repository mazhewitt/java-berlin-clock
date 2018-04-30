package com.ubs.opsit.interviews.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RowTest {

    @Test
    public void testNoLamps() {
        final Row row = new Row(4, Color.YELLOW);

        assertEquals("OOOO", row.toString());
    }

    @Test
    public void testThreeYellowLamps() {
        final Row row = new Row(4, Color.YELLOW);
        row.turnOn(3);

        assertEquals("YYYO", row.toString());
    }

    @Test
    public void testThreeRedLamps() {
        final Row row = new Row(4, Color.RED);
        row.turnOn(3);

        assertEquals("RRRO", row.toString());
    }

    @Test
    public void testLampOverflow() {
        final Row row = new Row(4, Color.YELLOW);
        row.turnOn(4);

        assertEquals("YYYY", row.toString());

        row.turnOn(1);

        assertEquals("YOOO", row.toString());
    }

    @Test
    public void testChangeColor() {
        final Row row = new Row(4, Color.YELLOW);
        row.turnOn(3);
        row.changeColor(Color.RED, 1,2);

        assertEquals("RRYO", row.toString());
    }

}
