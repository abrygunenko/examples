package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;

public abstract class AbstractGoogleWebPage extends AbstractWebPage {

    protected By searchInputFieldLocator = By.id("lst-ib");


    public AbstractGoogleWebPage(String pageTitle, String baseUrlSuffix) {
        super(pageTitle, "https://www.google.pl/", baseUrlSuffix);
    }

    @Override
    public IWebPage initializePage() {
        super.initializePage();
        locateElement(searchInputFieldLocator);
        return this;
    }

    public GoogleSearchResultsWebPage search(String textToSearch) {
        enterValue(searchInputFieldLocator, textToSearch);
        submitForm(searchInputFieldLocator);
        return new GoogleSearchResultsWebPage(textToSearch).initializePage();
    }

    public GoogleSearchResultsWebPage searchForSeleniumHQ() {
        return search("SeleniumHQ");
    }
}
