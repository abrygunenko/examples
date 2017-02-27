package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.Browser;
import org.openqa.selenium.WebDriver;

public class MainGoogleWebPage extends AbstractGoogleWebPage {

    public MainGoogleWebPage(WebDriver webDriver, Browser browser) {
        super(webDriver, browser, "Google", "");
    }

    @Override
    public MainGoogleWebPage initializePage() {
        super.initializePage();
        return this;
    }
}
