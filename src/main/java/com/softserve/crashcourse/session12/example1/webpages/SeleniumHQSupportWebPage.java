package com.softserve.crashcourse.session12.example1.webpages;

public class SeleniumHQSupportWebPage extends AbstractSeleniumHQWebPage {

    public SeleniumHQSupportWebPage() {
        super("Getting Help", "support/");
    }

    @Override
    public SeleniumHQSupportWebPage initializePage() {
        super.initializePage();
        return this;
    }
}
