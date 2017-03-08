package com.softserve.crashcourse.session16.example1;

import com.softserve.crashcourse.session12.example1.webpages.AbstractWebPage;
import com.softserve.crashcourse.session12.example1.webpages.IWebPage;
import org.openqa.selenium.By;

public abstract class AbstractITWeekendWebPage extends AbstractWebPage {

    protected By myAccountButtonLocator = By.cssSelector("div.navbar__account");
    protected By logOutButtonLocator = By.cssSelector(".dropdown-menu > li:nth-child(3) > a");

    public AbstractITWeekendWebPage(String pageTitle, String baseUrlSuffix) {
        super(pageTitle, "http://195.160.232.127/#/", baseUrlSuffix);
    }

    @Override
    public IWebPage initializePage() {
        super.initializePage();
        locateElement(myAccountButtonLocator);

        return this;
    }

    public ITWeekendLoginPage navigateToLoginPage() {
        clickOnElement(myAccountButtonLocator);
        return new ITWeekendLoginPage().initializePage();
    }

    public ITWeekendMainPage logOut() {
        clickOnElement(myAccountButtonLocator);
        clickOnElement(logOutButtonLocator);
        return new ITWeekendMainPage().initializePage();
    }

    public ITWeekendProfilePage logIn(String login, String password) {
        ITWeekendLoginPage loginPage = navigateToLoginPage();
        return loginPage.logIn(login, password);
    }
}
