package com.softserve.crashcourse.session12.example1.webmodalwindow;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;

public abstract class AbstractWebPageModalWindow extends AbstractWebPageSegment implements IWebPageModalWindow {

    public AbstractWebPageModalWindow() {
        super();
    }

    @Override
    public abstract void initializeModalWindow();

}
