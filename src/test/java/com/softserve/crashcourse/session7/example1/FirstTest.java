package com.softserve.crashcourse.session7.example1;

import org.testng.annotations.Test;

import java.util.Properties;

public class FirstTest {

    @Test
    public void test1() {
        Properties properties = java.lang.System.getProperties();
        System.out.println("All System Properties: ");
        properties.list(System.out);
    }

    @Test
    public void test2() {
        System.out.println("Selenium Version: " + System.getProperty("org.seleniumhq.selenium-version"));
    }
}
