package com.softserve.crashcourse.session8.example5;

import org.testng.annotations.Test;

public class TestNGTest10 {

    @Test(dependsOnMethods = {"method2"})
    public void method1() {
        System.out.println("This is method 1");
    }

    @Test
    public void method2() {
        System.out.println("This is method 2");
    }
}
