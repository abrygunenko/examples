package com.softserve.crashcourse.session6.example1;

public class WrapperBox {
    private SimpleBox simpleBox = new SimpleBox();

    public void set(String text) {
        this.simpleBox.set(text);
    }

    public String get() {
        return (String) simpleBox.get();
    }
}
