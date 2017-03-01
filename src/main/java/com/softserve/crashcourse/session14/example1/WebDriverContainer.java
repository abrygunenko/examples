package com.softserve.crashcourse.session14.example1;

import com.softserve.crashcourse.session12.example1.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.softserve.crashcourse.session12.example1.Browser.*;

public class WebDriverContainer {

    private WebDriver webDriver;
    private final Browser browser = getExpectedBrowser();

    public WebDriver getWebDriver() {
        return webDriver;
    }

    private WebDriverContainer() {
        webDriver = init();
    }

    private static class WebDriverContainerHolder {
        private static final WebDriverContainer HOLDER_INSTANCE = new WebDriverContainer();
    }

    public static WebDriverContainer getInstance() {
        return WebDriverContainerHolder.HOLDER_INSTANCE;
    }

    private static Browser getExpectedBrowser() {
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

    private WebDriver init() {
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
        return webDriver;
    }

    public void close() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverContainer webDriverContainer = getInstance();
        webDriverContainer.getWebDriver().get("http://google.pl/");
        Thread.sleep(5000);
        webDriverContainer.close();
    }
}
