package com.softserve.crashcourse.session12.example1;

import com.softserve.crashcourse.session12.example1.webpages.SeleniumHQDownloadsWebPage;
import com.softserve.crashcourse.session12.example1.webpages.GoogleMainWebPage;
import com.softserve.crashcourse.session12.example1.webpages.SeleniumHQMainWebPage;
import com.softserve.crashcourse.session12.example1.webpages.GoogleSearchResultsWebPage;
import org.testng.annotations.Test;

public class ExampleTest extends BaseWebTest {

    @Test(testName = "Test Example", groups = "default")
    public void exampleTest() {
        GoogleMainWebPage googleMainWebPage = new GoogleMainWebPage();
        googleMainWebPage.openPage();
        GoogleSearchResultsWebPage googleSearchResultsWebPage = googleMainWebPage.searchForSeleniumHQ();
        SeleniumHQMainWebPage seleniumHQMainWebPage = googleSearchResultsWebPage.navigateToMainSeleniumHQWebPage();
        SeleniumHQDownloadsWebPage seleniumHQDownloadsWebPage = seleniumHQMainWebPage.navigateToDownloadsSeleniumHQWebPage();
        seleniumHQDownloadsWebPage.verifySeleniumJavaVersion("3.1.0");
    }
}
