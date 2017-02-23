package com.softserve.crashcourse.session12.example1.webmodalwindow;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebPageModalWindow extends AbstractWebPageSegment implements IWebPageModalWindow {

    public AbstractWebPageModalWindow(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public abstract void initializeModalWindow();

}
