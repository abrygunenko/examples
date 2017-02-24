package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.WebDriver;

public class MainGoogleWebPage extends AbstractGoogleWebPage {

    public MainGoogleWebPage(WebDriver webDriver) {
        super(webDriver, "");
    }

    @Override
    public MainGoogleWebPage initializePage() {
        super.initializePage();
        verifyWebPageTitle("Google");
        return this;
    }
}
