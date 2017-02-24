package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsGoogleWebPage extends AbstractGoogleWebPage {

    protected String textToSearch;
    private By searchResultsNavigationBarSelector = By.id("navcnt");

    public SearchResultsGoogleWebPage(WebDriver webDriver, String textToSearch) {
        super(webDriver, "#q=" + textToSearch + "&*");
        this.textToSearch = textToSearch;
    }

    @Override
    public SearchResultsGoogleWebPage initializePage() {
        super.initializePage();
        locateElement(searchResultsNavigationBarSelector);
        verifyWebPageTitle(textToSearch + " - Szukaj w Google");
        return this;
    }

    public void navigateToSearchResultByLink(String link) {
        clickOnElement(By.cssSelector("a[href='" + link + "']"));
    }

    public MainSeleniumHQWebPage navigateToMainSeleniumHQWebPage() {
        navigateToSearchResultByLink("http://www.seleniumhq.org/");
        return new MainSeleniumHQWebPage(getWebDriver()).initializePage();
    }
}
