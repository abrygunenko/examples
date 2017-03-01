package com.softserve.crashcourse.session12.example1.webpages;

public class SeleniumHQDocumentsWebPage extends AbstractSeleniumHQWebPage {

    public SeleniumHQDocumentsWebPage() {
        super("Selenium Documentation — Selenium Documentation", "docs/");
    }

    @Override
    public SeleniumHQDocumentsWebPage initializePage() {
        super.initializePage();
        return this;
    }
}
