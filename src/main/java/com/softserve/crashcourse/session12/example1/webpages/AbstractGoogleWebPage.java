package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractGoogleWebPage extends AbstractWebPage {

    public AbstractGoogleWebPage(WebDriver webDriver, String baseUrlSuffix) {
        super(webDriver, "https://www.google.pl/", baseUrlSuffix);
    }

    @Override
    public abstract void initializePage();

}
