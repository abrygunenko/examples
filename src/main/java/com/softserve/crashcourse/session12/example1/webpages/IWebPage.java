package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.IWebPageSegment;

public interface IWebPage extends IWebPageSegment {

    IWebPage initializePage();

    IWebPage openPage();

    IWebPage refreshPage();

    String getWebPageTitle();

    String getWebPageUrl();

    Boolean verifyWebPageTitle(String expectedWebPageTitle);
}
