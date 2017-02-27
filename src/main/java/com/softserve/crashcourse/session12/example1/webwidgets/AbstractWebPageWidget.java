package com.softserve.crashcourse.session12.example1.webwidgets;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;
import com.softserve.crashcourse.session12.example1.Browser;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebPageWidget extends AbstractWebPageSegment implements IWebPageWidget {

    public AbstractWebPageWidget(WebDriver webDriver, Browser browser) {
        super(webDriver, browser);
    }

    @Override
    public abstract void initializeWidget();

}
