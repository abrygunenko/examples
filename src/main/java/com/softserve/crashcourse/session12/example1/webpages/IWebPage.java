package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.IWebPageSegment;

public interface IWebPage extends IWebPageSegment {

    void initializePage();

    IWebPage openPage();

}
