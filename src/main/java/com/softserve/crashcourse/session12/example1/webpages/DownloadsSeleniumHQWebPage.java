package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;

public class DownloadsSeleniumHQWebPage extends AbstractSeleniumHQWebPage {

    private By seleniumJavaVersionLocator = By.cssSelector("p +table > tbody > tr:first-child > td:nth-child(2)");
    private By navigationMenu = By.id("nav");

    public DownloadsSeleniumHQWebPage() {
        super("Downloads", "download/");
    }

    @Override
    public DownloadsSeleniumHQWebPage initializePage() {
        super.initializePage();
        locateElement(navigationMenu);
        locateElement(seleniumJavaVersionLocator);
        return this;
    }

    public Boolean verifySeleniumJavaVersion(String expectedSeleniumJavaVersion) {
        return verifyElementText(seleniumJavaVersionLocator, expectedSeleniumJavaVersion);
    }
}
