package com.softserve.crashcourse.session12.example1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.softserve.crashcourse.session12.example1.Browser.EDGE;
import static com.softserve.crashcourse.session12.example1.Browser.IE;

public abstract class BaseWebTest {

    protected WebDriver getWebDriver() {
        return WebDriverBuilder.INSTANCE.getWebDriver();
    }

    protected Browser getBrowser() {
        return WebDriverBuilder.INSTANCE.getBrowser();
    }

    @BeforeSuite
    public WebDriver initializeWebDriver() {
        WebDriver webDriver = WebDriverBuilder.INSTANCE.getWebDriver();
        Browser browser = WebDriverBuilder.INSTANCE.getBrowser();

        if (!(browser.equals(IE) || browser.equals(EDGE))) {
            webDriver.manage().deleteAllCookies();
        }

        webDriver.manage().window().maximize();
        return webDriver;
    }

    @AfterSuite(alwaysRun = true)
    public void closeWebDriver() {
        getWebDriver().quit();
    }
}
