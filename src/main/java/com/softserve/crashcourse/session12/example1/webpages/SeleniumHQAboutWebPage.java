package com.softserve.crashcourse.session12.example1.webpages;

public class SeleniumHQAboutWebPage extends AbstractSeleniumHQWebPage {

    public SeleniumHQAboutWebPage() {
        super("About Selenium", "about/");
    }

    @Override
    public SeleniumHQAboutWebPage initializePage() {
        super.initializePage();
        return this;
    }
}
