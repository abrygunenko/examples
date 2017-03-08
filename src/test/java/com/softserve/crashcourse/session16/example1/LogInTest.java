package com.softserve.crashcourse.session16.example1;

import com.softserve.crashcourse.session12.example1.BaseWebTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LogInTest extends BaseWebTest {
    private final String login = "abryg+2@softserveinc.com";
    private final String password = "P@$$w0rd";
    private ITWeekendProfilePage profilePage;

    @Test(testName = "ITWeekend Log In Test", groups = "default")
    public void logInTest() {
        ITWeekendMainPage mainPage = new ITWeekendMainPage();
        mainPage.openPage();
        ITWeekendLoginPage loginPage = mainPage.navigateToLoginPage();
        profilePage = loginPage.logIn(login, password);
        profilePage.verifyUserLoggedIn(login);
    }

    @AfterClass(alwaysRun = true)
    public void logOut() {
        profilePage.logOut();
    }
}
