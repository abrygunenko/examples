package com.softserve.crashcourse.session12.example1;

public enum Browser {

    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("edge"),
    IE("ie"),
    SAFARI("safari");

    private String browserName;

    public String getBrowserName() {
        return browserName;
    }

    Browser(String browserName) {
        this.browserName = browserName;
    }
}
