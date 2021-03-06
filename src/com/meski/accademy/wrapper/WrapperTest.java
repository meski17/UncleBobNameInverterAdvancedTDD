package com.meski.accademy.wrapper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WrapperTest {

    @Before
    public void setup() {

    }

    @Test
    public void shouldWrap() throws Exception {
        assertWraps("", 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
        assertWraps("xx", 1, "x\nx");
        assertWraps("xxx", 1, "x\nx\nx");
        assertWraps("x x", 1, "x\nx");
        assertWraps("x xx", 3, "x\nxx");
    }

    private void assertWraps(String s, int width, String expected) {
        assertEquals(expected, wrap(s, width));
    }

    private String wrap(String s, int width) {
        if (s == null)
            return "";
        if (s.length() <= width)
            return s;
        else {
            int breakPoint = s.lastIndexOf(" ", width);
            if (breakPoint == -1)
                breakPoint = width;
            return s.substring(0, breakPoint) + "\n" + wrap(s.substring(breakPoint).trim(), width);
        }
    }
}
