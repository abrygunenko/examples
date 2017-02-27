package com.softserve.crashcourse.session12.example1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.softserve.crashcourse.session12.example1.Browser.*;

public abstract class BaseWebTest {
    private WebDriver webDriver;
    private String browserName = System.getProperty("browser");
    private Browser browser;

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    protected WebDriver setWebDriver(WebDriver webDriver) {
        return this.webDriver = webDriver;
    }

    protected Browser getBrowser() {
        return browser;
    }

    protected Browser setBrowser(Browser browser) {
        this.browser = browser;
        return getBrowser();
    }

    @BeforeSuite
    public WebDriver initializeWebDriver() {
        WebDriver webDriver;

        if (browserName.equals(FIREFOX.getBrowserName())) {
            webDriver = new FirefoxDriver();
            setBrowser(FIREFOX);
        } else if (browserName.equals(CHROME.getBrowserName())) {
            webDriver = new ChromeDriver();
            setBrowser(CHROME);
        } else if (browserName.equals(EDGE.getBrowserName())) {
            webDriver = new EdgeDriver();
            setBrowser(EDGE);
        } else if (browserName.equals(IE.getBrowserName())) {
            webDriver = new InternetExplorerDriver();
            setBrowser(IE);
        } else if (browserName.equals(SAFARI.getBrowserName())) {
            webDriver = new SafariDriver();
            setBrowser(SAFARI);
        } else {
            webDriver = new FirefoxDriver();
            setBrowser(FIREFOX);
        }

        if (!(getBrowser().equals(IE) || getBrowser().equals(EDGE))) {
            webDriver.manage().deleteAllCookies();
        }

        webDriver.manage().window().maximize();
        setWebDriver(webDriver);
        return webDriver;
    }

    @AfterSuite(alwaysRun = true)
    public void closeWebDriver() {
        getWebDriver().quit();
    }
}
