package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainSeleniumHQWebPage extends AbstractSeleniumHQWebPage {

    protected By testBirdsLogoLocator = By.cssSelector(
            "a[href='https://www.testbirds.com/services/quality-assurance/testing-environment" +
                    "/?utm_source=seleniumhq&utm_campaign=int-cloud-logo-sponsoring-seleniumhq&utm_medium=logo-sponsoring']"
                    + " > img[src='/sponsors/testbirds.jpg']");


    public MainSeleniumHQWebPage(WebDriver webDriver) {
        super(webDriver, "");
    }

    @Override
    public MainSeleniumHQWebPage initializePage() {
        super.initializePage();
        locateElement(testBirdsLogoLocator);
        verifyWebPageTitle("Selenium - Web Browser Automation");
        return this;
    }
}
