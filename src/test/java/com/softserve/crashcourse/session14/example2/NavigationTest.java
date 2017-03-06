package com.softserve.crashcourse.session14.example2;

import com.softserve.crashcourse.session12.example1.BaseWebTest;
import com.softserve.crashcourse.session12.example1.webpages.SeleniumHQMainWebPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

public class NavigationTest extends BaseWebTest {
    private SeleniumHQMainWebPage seleniumHQMainWebPage;

    @BeforeClass
    public void openSeleniumHQMainPage() {
        seleniumHQMainWebPage = new SeleniumHQMainWebPage();
        seleniumHQMainWebPage.openPage();
    }

    @AfterMethod(alwaysRun = true, dependsOnGroups = "report")
    public void navigateToMainPage() {
        seleniumHQMainWebPage.navigateToMainSeleniumHQWebPage();
    }

    @Step("Navigate to Projects page")
    @Test(testName = "Navigate to Projects page", groups = "navigation")
    public void navigateToProjectsPageTest() {
        seleniumHQMainWebPage.navigateToProjectsSeleniumHQWebPage();
    }

    @Step("Navigate to Documents page")
    @Test(testName = "Navigate to Documents page", groups = "navigation")
    public void navigateToDocumentsPageTest() {
        seleniumHQMainWebPage.navigateToDocumentsSeleniumHQWebPage();
    }

    @Step("Navigate to Downloads page")
    @Test(testName = "Navigate to Downloads page", groups = "navigation")
    public void navigateToDownloadsPageTest() {
        seleniumHQMainWebPage.navigateToDownloadsSeleniumHQWebPage();
    }

    @Step("Navigate to Support page")
    @Test(testName = "Navigate to Support page", groups = "navigation")
    public void navigateToSupportPageTest() {
        seleniumHQMainWebPage.navigateToSupportSeleniumHQWebPage();
    }

    @Step("Navigate to About page")
    @Test(testName = "Navigate to About page", groups = "navigation")
    public void navigateToAboutPageTest() {
        seleniumHQMainWebPage.navigateToAboutSeleniumHQWebPage();
    }

    @Step("Navigate to Main page")
    @Test(testName = "Navigate to Main page", groups = "navigation")
    public void navigateToMainPageTest() {
        seleniumHQMainWebPage.navigateToMainSeleniumHQWebPage();
    }
}
