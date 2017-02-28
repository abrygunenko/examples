package com.softserve.crashcourse.session12.example1;

import com.softserve.crashcourse.session12.example1.webpages.DownloadsSeleniumHQWebPage;
import com.softserve.crashcourse.session12.example1.webpages.MainGoogleWebPage;
import com.softserve.crashcourse.session12.example1.webpages.MainSeleniumHQWebPage;
import com.softserve.crashcourse.session12.example1.webpages.SearchResultsGoogleWebPage;
import org.testng.annotations.Test;

public class ExampleTest extends BaseWebTest {

    @Test
    public void exampleTest() {
        MainGoogleWebPage mainGoogleWebPage = new MainGoogleWebPage();
        mainGoogleWebPage.openPage();
        SearchResultsGoogleWebPage searchResultsGoogleWebPage = mainGoogleWebPage.searchForSeleniumHQ();
        MainSeleniumHQWebPage mainSeleniumHQWebPage = searchResultsGoogleWebPage.navigateToMainSeleniumHQWebPage();
        DownloadsSeleniumHQWebPage downloadsSeleniumHQWebPage = mainSeleniumHQWebPage.navigateToDownloadsSeleniumHQWebPage();
        downloadsSeleniumHQWebPage.verifySeleniumJavaVersion("3.1.0");
    }
}
