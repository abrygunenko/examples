package com.softserve.crashcourse.session16.example1;

import org.openqa.selenium.By;

public class ITWeekendProfilePage extends AbstractITWeekendWebPage{

    private By emailFieldLabelSelector = By.cssSelector("div.my-profile__item:nth-child(3) > label.my-profile__label");
    private By emailFieldValueSelector = By.cssSelector("div.my-profile__item:nth-child(3) > label.my-profile__field");

    public ITWeekendProfilePage() {
        super("My Profile · IT Weekend", "profile/");
    }

    public ITWeekendProfilePage initializePage() {
        super.initializePage();
        verifyElementText(emailFieldLabelSelector, "E-mail");
        locateElement(emailFieldValueSelector);
        return this;
    }

    public void verifyUserLoggedIn(String login) {
        verifyElementText(emailFieldValueSelector, login);
    }
}
