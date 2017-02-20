package com.softserve.crashcourse.session11.example1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitExample {

    long implicitlyWaitTimeout = 10;

    public long getImplicitlyWaitTimeout() {
        return implicitlyWaitTimeout;
    }

    public WebDriver getWebDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts()
                .implicitlyWait(getImplicitlyWaitTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement getWebElement(String name) {
        WebElement webElement = new WebDriverWait(
                getWebDriver(), getImplicitlyWaitTimeout())
                .until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        if (webElement == null) {
            throw new RuntimeException("My Error");
        }
        return webElement;
    }
}
