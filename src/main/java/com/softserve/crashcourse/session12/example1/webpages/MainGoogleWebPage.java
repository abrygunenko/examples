package com.softserve.crashcourse.session12.example1.webpages;

public class MainGoogleWebPage extends AbstractGoogleWebPage {

    public MainGoogleWebPage() {
        super("Google", "");
    }

    @Override
    public MainGoogleWebPage initializePage() {
        super.initializePage();
        return this;
    }
}
