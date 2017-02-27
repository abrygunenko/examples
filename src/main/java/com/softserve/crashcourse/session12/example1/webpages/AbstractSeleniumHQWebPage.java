package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.webwidgets.SeleniumHQHeaderWidget;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSeleniumHQWebPage extends AbstractWebPage {

    private SeleniumHQHeaderWidget seleniumHQHeaderWidget;

    public AbstractSeleniumHQWebPage(WebDriver webDriver, String baseUrlSuffix) {
        super(webDriver, "http://www.seleniumhq.org/", baseUrlSuffix);
        seleniumHQHeaderWidget = new SeleniumHQHeaderWidget(webDriver);
    }

    @Override
    public IWebPage initializePage() {
        seleniumHQHeaderWidget.initializeWidget();
        return this;
    }

    public DownloadsSeleniumHQWebPage navigateToDownloadsSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToDownloadsPage();
    }
}
