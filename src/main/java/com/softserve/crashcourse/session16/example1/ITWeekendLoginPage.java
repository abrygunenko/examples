package com.softserve.crashcourse.session16.example1;

import org.openqa.selenium.By;

public class ITWeekendLoginPage extends AbstractITWeekendWebPage{

    private By emailInputFieldLocator = By.id("email");
    private By passwordInputFieldLocator = By.id("new_password1");
    private By logInButtonLocator = By.cssSelector("button.btn");

    public ITWeekendLoginPage() {
        super("Login · IT Weekend", "auth/login/");
    }

    public ITWeekendLoginPage initializePage() {
        super.initializePage();
        locateElement(emailInputFieldLocator);
        locateElement(passwordInputFieldLocator);
        verifyElementText(logInButtonLocator, "LOG IN");
        return this;
    }

    public ITWeekendProfilePage logIn(String login, String password) {
        enterValue(emailInputFieldLocator, login);
        enterValue(passwordInputFieldLocator, password);
        clickOnElement(logInButtonLocator);
        return new ITWeekendProfilePage().initializePage();
    }
}
