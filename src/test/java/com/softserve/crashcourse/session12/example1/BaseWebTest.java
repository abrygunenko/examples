package com.softserve.crashcourse.session12.example1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseWebTest {
    private WebDriver webDriver;
    private String browser = System.getProperty("browser");

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    protected WebDriver setWebDriver(WebDriver webDriver) {
        return this.webDriver = webDriver;
    }

    @BeforeSuite
    public WebDriver initializeWebDriver() {
        WebDriver webDriver;

        if (browser.equals("firefox")) {
            webDriver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            webDriver = new EdgeDriver();
        } else if (browser.equals("ie")) {
            webDriver = new InternetExplorerDriver();
        } else if (browser.equals("safari")) {
            webDriver = new SafariDriver();
        } else {
            webDriver = new FirefoxDriver();
        }

        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        setWebDriver(webDriver);
        return webDriver;
    }

    @AfterSuite(alwaysRun = true)
    public void closeWebDriver() {
        getWebDriver().quit();
    }
}
