package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSeleniumHQWebPage extends AbstractWebPage {

    protected By downloadTabLocator = By.cssSelector("#menu_download > a");

    public AbstractSeleniumHQWebPage(WebDriver webDriver, String baseUrlSuffix) {
        super(webDriver, "http://www.seleniumhq.org/", baseUrlSuffix);
    }

    @Override
    public IWebPage initializePage() {
        verifyElementText(downloadTabLocator, "Download");
        verifyElementAttributeValue(downloadTabLocator, "title", "Get Selenium");
        return this;
    }

    public DownloadsSeleniumHQWebPage navigateToDownloadsSeleniumHQWebPage() {
        clickOnElement(downloadTabLocator);
        return new DownloadsSeleniumHQWebPage(getWebDriver()).initializePage();
    }
}
