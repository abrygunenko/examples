package com.softserve.crashcourse.session14.example2;

import com.softserve.crashcourse.session12.example1.BaseWebTest;
import com.softserve.crashcourse.session12.example1.webpages.SeleniumHQMainWebPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationTest extends BaseWebTest {
    private SeleniumHQMainWebPage seleniumHQMainWebPage;

    @BeforeClass
    public void openSeleniumHQMainPage() {
        seleniumHQMainWebPage = new SeleniumHQMainWebPage();
        seleniumHQMainWebPage.openPage();
    }

    @AfterMethod(alwaysRun = true)
    public void navigateToMainPage() {
        seleniumHQMainWebPage.navigateToMainSeleniumHQWebPage();
    }

    @Test
    public void navigateToProjectsPageTest() {
        seleniumHQMainWebPage.navigateToProjectsSeleniumHQWebPage();
    }

    @Test
    public void navigateToDocumentsPageTest() {
        seleniumHQMainWebPage.navigateToDocumentsSeleniumHQWebPage();
    }

    @Test
    public void navigateToDownloadsPageTest() {
        seleniumHQMainWebPage.navigateToDownloadsSeleniumHQWebPage();
    }

    @Test
    public void navigateToSupportPageTest() {
        seleniumHQMainWebPage.navigateToSupportSeleniumHQWebPage();
    }

    @Test
    public void navigateToAboutPageTest() {
        seleniumHQMainWebPage.navigateToAboutSeleniumHQWebPage();
    }

    @Test
    public void navigateToMainPageTest() {
        seleniumHQMainWebPage.navigateToMainSeleniumHQWebPage();
    }
}
