package com.softserve.crashcourse.session12.example1.webwidgets;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;

public abstract class AbstractWebPageWidget extends AbstractWebPageSegment implements IWebPageWidget {

    public AbstractWebPageWidget() {
        super();
    }

    @Override
    public abstract void initializeWidget();

}
