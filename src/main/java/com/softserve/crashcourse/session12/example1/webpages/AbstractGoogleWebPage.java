package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractGoogleWebPage extends AbstractWebPage {

    protected By searchInputFieldLocator = By.id("lst-ib");


    public AbstractGoogleWebPage(WebDriver webDriver, Browser browser, String pageTitle, String baseUrlSuffix) {
        super(webDriver, browser, pageTitle, "https://www.google.pl/", baseUrlSuffix);
    }

    @Override
    public IWebPage initializePage() {
        super.initializePage();
        locateElement(searchInputFieldLocator);
        return this;
    }

    public SearchResultsGoogleWebPage search(String textToSearch) {
        enterValue(searchInputFieldLocator, textToSearch);
        submitForm(searchInputFieldLocator);
        return new SearchResultsGoogleWebPage(getWebDriver(), getBrowser(), textToSearch).initializePage();
    }

    public SearchResultsGoogleWebPage searchForSeleniumHQ() {
        return search("SeleniumHQ");
    }
}
