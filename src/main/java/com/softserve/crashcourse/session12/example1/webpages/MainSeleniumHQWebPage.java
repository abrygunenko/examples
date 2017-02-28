package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;

import static com.softserve.crashcourse.session12.example1.Browser.IE;

public class MainSeleniumHQWebPage extends AbstractSeleniumHQWebPage {

    protected By testBirdsLogoLocator = By.cssSelector("img[src='/sponsors/testbirds.jpg']");


    public MainSeleniumHQWebPage() {
        super("Selenium - Web Browser Automation", "");
    }

    @Override
    public MainSeleniumHQWebPage initializePage() {
        super.initializePage();
        if (!(getBrowser().equals(IE))) {
            locateElement(testBirdsLogoLocator);
        }
        return this;
    }
}
