package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.webwidgets.SeleniumHQHeaderWidget;

public abstract class AbstractSeleniumHQWebPage extends AbstractWebPage {

    private SeleniumHQHeaderWidget seleniumHQHeaderWidget;

    public AbstractSeleniumHQWebPage(String pageTitle, String baseUrlSuffix) {
        super(pageTitle, "http://www.seleniumhq.org/", baseUrlSuffix);
        seleniumHQHeaderWidget = new SeleniumHQHeaderWidget();
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
