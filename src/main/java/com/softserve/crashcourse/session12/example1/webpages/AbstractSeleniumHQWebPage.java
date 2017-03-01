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

    public SeleniumHQDownloadsWebPage navigateToDownloadsSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToDownloadsPage();
    }

    public SeleniumHQDocumentsWebPage navigateToDocumentsSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToDocumentsPage();
    }

    public SeleniumHQProjectsWebPage navigateToProjectsSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToProjectsPage();
    }

    public SeleniumHQSupportWebPage navigateToSupportSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToSupportPage();
    }

    public SeleniumHQAboutWebPage navigateToAboutSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToAboutPage();
    }

    public SeleniumHQMainWebPage navigateToMainSeleniumHQWebPage() {
        return seleniumHQHeaderWidget.navigateToMainPage();
    }
}
