package com.softserve.crashcourse.session12.example1.webwidgets;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebPageWidget extends AbstractWebPageSegment implements IWebPageWidget {

    public AbstractWebPageWidget(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public abstract void initializeWidget();

}
