package com.softserve.crashcourse.session12.example1.webwidgets;

import com.softserve.crashcourse.session12.example1.webpages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumHQHeaderWidget extends AbstractWebPageWidget {

    private By headerBodyLocator = By.id("header");
    private WebElement headerBody;
    private By headerTitleLocator = By.cssSelector("h1 > a");
    private By downloadTabLocator = By.cssSelector("#menu_download > a");
    private By supportTabLocator = By.cssSelector("#menu_support > a");
    private By documentationTabLocator = By.cssSelector("#menu_documentation > a");
    private By projectsTabLocator = By.cssSelector("#menu_projects > a");
    private By aboutTabLocator = By.cssSelector("#menu_about > a");

    public SeleniumHQHeaderWidget() {
        super();
    }

    @Override
    public void initializeWidget() {
        headerBody = locateElement(headerBodyLocator);
        verifyElementText(headerBody, headerTitleLocator, "Browser Automation");
        verifyElementTitle(headerBody, headerTitleLocator, "Return to Selenium home page");
        verifyElementText(headerBody, downloadTabLocator, "Download");
        verifyElementTitle(headerBody, downloadTabLocator, "Get Selenium");
        verifyElementText(headerBody, supportTabLocator, "Support");
        verifyElementTitle(headerBody, supportTabLocator, "Get help with Selenium");
        verifyElementText(headerBody, documentationTabLocator, "Documentation");
        verifyElementTitle(headerBody, documentationTabLocator, "Technical references and guides");
        verifyElementText(headerBody, projectsTabLocator, "Projects");
        verifyElementTitle(headerBody, projectsTabLocator, "Selenium Projects");
        verifyElementText(headerBody, aboutTabLocator, "About");
        verifyElementTitle(headerBody, aboutTabLocator, "Overview of Selenium");
    }

    public SeleniumHQDownloadsWebPage navigateToDownloadsPage() {
        clickOnElement(downloadTabLocator);
        return new SeleniumHQDownloadsWebPage().initializePage();
    }

    public SeleniumHQDocumentsWebPage navigateToDocumentsPage() {
        clickOnElement(documentationTabLocator);
        return new SeleniumHQDocumentsWebPage().initializePage();
    }

    public SeleniumHQProjectsWebPage navigateToProjectsPage() {
        clickOnElement(projectsTabLocator);
        return new SeleniumHQProjectsWebPage().initializePage();
    }

    public SeleniumHQSupportWebPage navigateToSupportPage() {
        clickOnElement(supportTabLocator);
        return new SeleniumHQSupportWebPage().initializePage();
    }

    public SeleniumHQAboutWebPage navigateToAboutPage() {
        clickOnElement(aboutTabLocator);
        return new SeleniumHQAboutWebPage().initializePage();
    }

    public SeleniumHQMainWebPage navigateToMainPage() {
        clickOnElement(headerTitleLocator);
        return new SeleniumHQMainWebPage().initializePage();
    }
}
