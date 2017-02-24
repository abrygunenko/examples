package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractGoogleWebPage extends AbstractWebPage {

    protected By searchInputFieldLocator = By.id("lst-ib");


    public AbstractGoogleWebPage(WebDriver webDriver, String baseUrlSuffix) {
        super(webDriver, "https://www.google.pl/", baseUrlSuffix);
    }

    @Override
    public IWebPage initializePage() {
        locateElement(searchInputFieldLocator);
        return this;
    }

    public SearchResultsGoogleWebPage search(String textToSearch) {
        enterValue(searchInputFieldLocator, textToSearch);
        submitForm(searchInputFieldLocator);
        return new SearchResultsGoogleWebPage(getWebDriver(), textToSearch).initializePage();
    }
}
