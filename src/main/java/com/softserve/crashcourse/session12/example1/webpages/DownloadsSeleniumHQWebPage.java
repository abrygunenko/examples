package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadsSeleniumHQWebPage extends AbstractSeleniumHQWebPage {

    protected By seleniumJavaVersionLocator = By.cssSelector("p +table > tbody > tr:first-child > td:nth-child(2)");
    protected By navigationMenu = By.id("nav");

    public DownloadsSeleniumHQWebPage(WebDriver webDriver) {
        super(webDriver, "download/");
    }

    @Override
    public DownloadsSeleniumHQWebPage initializePage() {
        super.initializePage();
        locateElement(navigationMenu);
        locateElement(seleniumJavaVersionLocator);
        verifyWebPageTitle("Downloads");
        return this;
    }

    public Boolean verifySeleniumJavaVersion(String expectedSeleniumJavaVersion) {
        return verifyElementText(seleniumJavaVersionLocator, expectedSeleniumJavaVersion);
    }
}
