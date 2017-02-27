package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.Browser;
import com.softserve.crashcourse.session12.example1.webwidgets.SeleniumHQHeaderWidget;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSeleniumHQWebPage extends AbstractWebPage {

    private SeleniumHQHeaderWidget seleniumHQHeaderWidget;

    public AbstractSeleniumHQWebPage(WebDriver webDriver, Browser browser, String pageTitle, String baseUrlSuffix) {
        super(webDriver, browser, pageTitle, "http://www.seleniumhq.org/", baseUrlSuffix);
        seleniumHQHeaderWidget = new SeleniumHQHeaderWidget(webDriver, browser);
    }

    @Override
    public IWebPage initializePage() {
        super.initializePage();
        seleniumHQHeaderWidget.initializeWidget();
        return this;
    }

    public DownloadsSeleniumHQWebPage navigateToDownloadsSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToDownloadsPage();
    }
}
