package com.softserve.crashcourse.session11.example2;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class TestSample {
    WebDriver driver;

    @Before
    public void setUp() {
        // Start new WebDriver session, e.g. using Firefox
        driver = new FirefoxDriver();
    }

    @Test
    public void aTest() {
        driver.get("http://www.google.com/");
        // more test logic  - test might pass or fail at this point
    }

    @After
    public void tearDown() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshto to a file some place
        try {
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
