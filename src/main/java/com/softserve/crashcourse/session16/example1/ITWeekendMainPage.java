package com.softserve.crashcourse.session16.example1;

import org.openqa.selenium.By;

public class ITWeekendMainPage extends AbstractITWeekendWebPage{

    private By mainPageTitleLocator = By.cssSelector("div.jumbotron__title");

    public ITWeekendMainPage() {
        super("IT Weekend", "");
    }

    public ITWeekendMainPage initializePage() {
        super.initializePage();
        verifyElementText(mainPageTitleLocator, "IT WEEKEND");
        return this;
    }
}
