package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.softserve.crashcourse.session12.example1.Browser.IE;

public class MainSeleniumHQWebPage extends AbstractSeleniumHQWebPage {

    protected By testBirdsLogoLocator = By.cssSelector("img[src='/sponsors/testbirds.jpg']");


    public MainSeleniumHQWebPage(WebDriver webDriver, Browser browser) {
        super(webDriver, browser, "Selenium - Web Browser Automation", "");
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
