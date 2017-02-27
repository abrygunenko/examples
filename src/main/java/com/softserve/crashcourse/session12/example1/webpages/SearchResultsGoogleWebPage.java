package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.softserve.crashcourse.session12.example1.Browser.EDGE;
import static com.softserve.crashcourse.session12.example1.Browser.IE;

public class SearchResultsGoogleWebPage extends AbstractGoogleWebPage {

    protected String textToSearch;
    private By searchResultsNavigationBarSelector = By.id("navcnt");

    public SearchResultsGoogleWebPage(WebDriver webDriver, Browser browser, String textToSearch) {
        super(webDriver, browser, textToSearch + " - Szukaj w Google", "#q=" + textToSearch + "&*");

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
        return new MainSeleniumHQWebPage(getWebDriver(), getBrowser()).initializePage();
    }
}
