package com.softserve.crashcourse.session7.example2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoTest {
    @Test
    public void TestResume() {
        One one = new One();
        one.setText("Integration Test");
        Two two = new Two(one);
        // TODO Initialize to an appropriate value
        String expected = "Integration Test_0";    // Result ???
        String actual;
        actual = two.resume();
        assertEquals(expected, actual);
    }
}
