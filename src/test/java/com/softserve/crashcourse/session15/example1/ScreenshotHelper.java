package com.softserve.crashcourse.session15.example1;

import com.softserve.crashcourse.session12.example1.WebDriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    private static String screenshotDirectoryPath = "target/reports/screenshots/";

    public static String captureScreenShot() {
        createDirectory(screenshotDirectoryPath);
        // Take screenshot and store as a file format
        String screenshotPath = screenshotDirectoryPath + "screenshot_" + System.currentTimeMillis() + ".png";
        File source = ((TakesScreenshot) WebDriverProvider.INSTANCE.getWebDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try {
            // now copy the  screenshot to desired location using copyFile method
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination.getAbsoluteFile().getParentFile().getName() + "/" + destination.getName();
    }

    public static void createDirectory(String directoryPath) {
        File path = new File(directoryPath);
        String pathToFolder = path.getAbsolutePath();
        if (!path.exists()) {
            boolean makeDirectory = new File(pathToFolder).mkdir();
            if (makeDirectory) {
                System.out.println("Directory '" + pathToFolder + "' successfully created");
            }
        }
    }
}
