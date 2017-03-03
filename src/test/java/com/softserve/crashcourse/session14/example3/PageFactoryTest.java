package com.softserve.crashcourse.session14.example3;

import com.softserve.crashcourse.session12.example1.BaseWebTest;
import com.softserve.crashcourse.session12.example1.webpages.*;
import org.testng.annotations.Test;

public class PageFactoryTest extends BaseWebTest {

    @Test(testName = "Page Factory Example", groups = "pageFactory")
    public void pageFactoryTest() {
        SeleniumHQAboutWebPage seleniumHQAboutWebPage = new SeleniumHQAboutWebPage();
        seleniumHQAboutWebPage.openPage();
        seleniumHQAboutWebPage.useDocumentationLink();
    }
}
