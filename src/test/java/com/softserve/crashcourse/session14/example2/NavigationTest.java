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

    @Test(testName = "Navigate to Projects page", groups = "navigation")
    public void navigateToProjectsPageTest() {
        seleniumHQMainWebPage.navigateToProjectsSeleniumHQWebPage();
    }

    @Test(testName = "Navigate to Documents page", groups = "navigation")
    public void navigateToDocumentsPageTest() {
        seleniumHQMainWebPage.navigateToDocumentsSeleniumHQWebPage();
    }

    @Test(testName = "Navigate to Downloads page", groups = "navigation")
    public void navigateToDownloadsPageTest() {
        seleniumHQMainWebPage.navigateToDownloadsSeleniumHQWebPage();
    }

    @Test(testName = "Navigate to Support page", groups = "navigation")
    public void navigateToSupportPageTest() {
        seleniumHQMainWebPage.navigateToSupportSeleniumHQWebPage();
    }

    @Test(testName = "Navigate to About page", groups = "navigation")
    public void navigateToAboutPageTest() {
        seleniumHQMainWebPage.navigateToAboutSeleniumHQWebPage();
    }

    @Test(testName = "Navigate to Main page", groups = "navigation")
    public void navigateToMainPageTest() {
        seleniumHQMainWebPage.navigateToMainSeleniumHQWebPage();
    }
}
