package com.softserve.crashcourse.session12.example1.webpages;

public class GoogleMainWebPage extends AbstractGoogleWebPage {

    public GoogleMainWebPage() {
        super("Google", "");
    }

    @Override
    public GoogleMainWebPage initializePage() {
        super.initializePage();
        return this;
    }
}
