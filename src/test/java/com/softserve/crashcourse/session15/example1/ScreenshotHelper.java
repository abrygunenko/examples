package com.softserve.crashcourse.session15.example1;

import com.softserve.crashcourse.session12.example1.WebDriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    private static String screenshotDirectoryPath = "target/screenshots/";
    private static String screenshotFileName = "screenshot.png";

    public static String captureScreenShot() {
        // Take screenshot and store as a file format
        String screenshotPath = screenshotDirectoryPath + System.currentTimeMillis() + screenshotFileName;
        File src = ((TakesScreenshot) WebDriverProvider.INSTANCE.getWebDriver()).getScreenshotAs(OutputType.FILE);

        try {
            // now copy the  screenshot to desired location using copyFile method
            FileUtils.copyFile(src, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
