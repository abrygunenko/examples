package com.softserve.crashcourse.session11.example3;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitTool {

    public static WebElement waitForElementVisible(WebDriver driver,
                                                   final By by, long timeOutInSeconds) {
        WebElement webElement;
        try {
            // nullify implicitlyWait( )
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

            // Create web element
            webElement = new WebDriverWait(driver, timeOutInSeconds)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

            // reset implicitlyWait( )
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            webElement = null;
        }
        if (webElement == null) {
            throw new ElementNotVisibleException("Element isn't visible: " + by.toString());
        } else {
            return webElement;
        }
    }
}
