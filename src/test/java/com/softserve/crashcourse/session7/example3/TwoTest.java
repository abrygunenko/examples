package com.softserve.crashcourse.session7.example3;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoTest {
    @Test
    public void TestResume() {
        IOne one = new StubOne();
        one.setText("Unit Test");
        Two two = new Two(one);
        // TODO Initialize to an appropriate value
        String expected = "Unit Test_0";    // Result !!!
        String actual;
        actual = two.resume();
        assertEquals(expected, actual);
    }
}
