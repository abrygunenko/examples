package com.softserve.crashcourse.session14.example1;

import com.softserve.crashcourse.session12.example1.Browser;
import com.softserve.crashcourse.session12.example1.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.softserve.crashcourse.session12.example1.Browser.*;

public enum WebDriverBuilder {
    INSTANCE;

    private WebDriver webDriver;
    private final Browser browser = getExpectedBrowser();

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public Browser getBrowser() {
        return browser;
    }

    public String getBrowserName() {
        return browser.getBrowserName();
    }

    WebDriverBuilder() {
        if (browser.equals(FIREFOX)) {
            webDriver = new FirefoxDriver();
        } else if (browser.equals(CHROME)) {
            webDriver = new ChromeDriver();
        } else if (browser.equals(EDGE)) {
            webDriver = new EdgeDriver();
        } else if (browser.equals(IE)) {
            webDriver = new InternetExplorerDriver();
        } else if (browser.equals(SAFARI)) {
            webDriver = new SafariDriver();
        } else {
            webDriver = new FirefoxDriver();
        }

        if (!(browser.equals(IE) || browser.equals(EDGE))) {
            webDriver.manage().deleteAllCookies();
        }

        webDriver.manage().window().maximize();
    }

    private Browser getExpectedBrowser() {
        String browserName = System.getProperty("browser");

        if (browserName.equals(FIREFOX.getBrowserName())) {
            return FIREFOX;
        } else if (browserName.equals(CHROME.getBrowserName())) {
            return CHROME;
        } else if (browserName.equals(EDGE.getBrowserName())) {
            return EDGE;
        } else if (browserName.equals(IE.getBrowserName())) {
            return IE;
        } else if (browserName.equals(SAFARI.getBrowserName())) {
            return SAFARI;
        } else {
            return FIREFOX;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverProvider.INSTANCE.getWebDriver().get("http://google.pl/");
        Thread.sleep(5000);
        WebDriverProvider.INSTANCE.getWebDriver().quit();
    }
}
