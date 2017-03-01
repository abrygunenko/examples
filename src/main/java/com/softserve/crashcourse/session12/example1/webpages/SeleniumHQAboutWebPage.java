package com.softserve.crashcourse.session12.example1.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHQAboutWebPage extends AbstractSeleniumHQWebPage {

    @FindBy(css = "h3 > a[href='/docs'")
    private WebElement documentationLink;

    @FindBy(id = "aefefefsfe")
    private WebElement test;

    public SeleniumHQAboutWebPage() {
        super("About Selenium", "about/");
        PageFactory.initElements(getWebDriver(), this);
    }

    @Override
    public SeleniumHQAboutWebPage initializePage() {
        super.initializePage();
        documentationLink.isDisplayed();
//        test.isDisplayed();
        return this;
    }

    public SeleniumHQDocumentsWebPage useDocumentationLink() {
        documentationLink.click();
        return new SeleniumHQDocumentsWebPage().initializePage();
    }
}
