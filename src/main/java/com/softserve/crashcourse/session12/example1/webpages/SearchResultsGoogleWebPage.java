package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.By;

import static com.softserve.crashcourse.session12.example1.Browser.EDGE;
import static com.softserve.crashcourse.session12.example1.Browser.IE;

public class SearchResultsGoogleWebPage extends AbstractGoogleWebPage {

    protected String textToSearch;
    private By searchResultsNavigationBarSelector = By.id("navcnt");

    public SearchResultsGoogleWebPage(String textToSearch) {
        super(textToSearch + " - Szukaj w Google", "#q=" + textToSearch + "&*");

        if (getBrowser().equals(IE) || getBrowser().equals(EDGE)) {
            setPageTitle(textToSearch + " - Google Search");
        }

        this.textToSearch = textToSearch;
    }

    @Override
    public SearchResultsGoogleWebPage initializePage() {
        super.initializePage();
        locateElement(searchResultsNavigationBarSelector);
        return this;
    }

    public void navigateToSearchResultByLink(String link) {
        clickOnElement(By.cssSelector("a[href='" + link + "']"));
    }

    public MainSeleniumHQWebPage navigateToMainSeleniumHQWebPage() {
        navigateToSearchResultByLink("http://www.seleniumhq.org/");
        return new MainSeleniumHQWebPage().initializePage();
    }
}
