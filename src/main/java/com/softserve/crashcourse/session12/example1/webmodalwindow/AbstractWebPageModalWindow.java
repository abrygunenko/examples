package com.softserve.crashcourse.session12.example1.webmodalwindow;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;
import com.softserve.crashcourse.session12.example1.Browser;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebPageModalWindow extends AbstractWebPageSegment implements IWebPageModalWindow {

    public AbstractWebPageModalWindow(WebDriver webDriver, Browser browser) {
        super(webDriver, browser);
    }

    @Override
    public abstract void initializeModalWindow();

}
