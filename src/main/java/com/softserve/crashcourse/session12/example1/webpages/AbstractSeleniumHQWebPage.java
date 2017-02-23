package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractSeleniumHQWebPage extends AbstractWebPage {

    public AbstractSeleniumHQWebPage(WebDriver webDriver, String baseUrlSuffix) {
        super(webDriver, "http://www.seleniumhq.org/", baseUrlSuffix);
    }

    @Override
    public abstract void initializePage();

}
