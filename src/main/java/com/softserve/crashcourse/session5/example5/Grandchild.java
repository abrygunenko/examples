package com.softserve.crashcourse.session5.example5;

import com.softserve.crashcourse.session5.example6.Child;

public class Grandchild extends Child {
    public int y() {
        return this.f(); // ???
    }
}
