package com.softserve.crashcourse.session12.example1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.softserve.crashcourse.session12.example1.Browser.*;

public class WebDriverContainer {

    private static WebDriver webDriver;

    private WebDriverContainer() {}

    private static class WebDriverContainerHolder {
        private static final WebDriverContainer HOLDER_INSTANCE = new WebDriverContainer();
    }

    public static WebDriverContainer getInstance() {
        return WebDriverContainerHolder.HOLDER_INSTANCE;
    }

    public static WebDriverContainer instance() {
        return WebDriverContainerHolder.HOLDER_INSTANCE;
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public void init() {
        String browserName = System.getProperty("browser");

        if (browserName.equals(FIREFOX.getBrowserName())) {
            webDriver = new FirefoxDriver();
        } else if (browserName.equals(CHROME.getBrowserName())) {
            webDriver = new ChromeDriver();
        } else if (browserName.equals(EDGE.getBrowserName())) {
            webDriver = new EdgeDriver();
        } else if (browserName.equals(IE.getBrowserName())) {
            webDriver = new InternetExplorerDriver();
        } else if (browserName.equals(SAFARI.getBrowserName())) {
            webDriver = new SafariDriver();
        } else {
            webDriver = new FirefoxDriver();
        }
    }

    public void close() {
        if (webDriver != null) {
            webDriver.quit();
        } else
            System.out.println("null error");
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverContainer webDriverContainer = WebDriverContainer.instance();
        webDriverContainer.init();
        webDriverContainer.getDriver().get("http://google.pl/");
        Thread.sleep(5000);
        webDriverContainer.close();
    }
}
