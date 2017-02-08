package com.softserve.crashcourse.session8.example3;

import org.testng.annotations.*;

public class TestNGTest6 {
    @Test
    @Parameters(value = "number")
    public void parameterIntTest(int number) {
        System.out.println("Parameterized Number is: " + number);
    }
}
