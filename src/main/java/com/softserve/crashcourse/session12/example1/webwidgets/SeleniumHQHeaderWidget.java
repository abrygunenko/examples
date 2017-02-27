package com.softserve.crashcourse.session12.example1.webwidgets;

import com.softserve.crashcourse.session12.example1.Browser;
import com.softserve.crashcourse.session12.example1.webpages.DownloadsSeleniumHQWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHQHeaderWidget extends AbstractWebPageWidget {

    private By headerBodyLocator = By.id("header");
    private String baseHeaderSelector = "#header ";
    private WebElement headerBody;
    private By headerTitleLocator = By.cssSelector("h1 > a");
    private By downloadTabLocator = By.cssSelector("#menu_download > a");
    private By supportTabLocator = By.cssSelector("#menu_support > a");
    private By documentationTabLocator = By.cssSelector("#menu_documentation > a");
    private By projectsTabLocator = By.cssSelector("#menu_projects > a");

    public SeleniumHQHeaderWidget(WebDriver webDriver, Browser browser) {
        super(webDriver, browser);
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
    }

    public DownloadsSeleniumHQWebPage navigateToDownloadsPage() {
        clickOnElement(headerBody, downloadTabLocator);
        return new DownloadsSeleniumHQWebPage(getWebDriver(), getBrowser()).initializePage();
    }
}
