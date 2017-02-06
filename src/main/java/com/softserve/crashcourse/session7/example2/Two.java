package com.softserve.crashcourse.session7.example2;

public class Two {
    private One one;

    public Two(One one) {
        this.one = one;
    }

    public String resume() {
        // Functionality
        return one.getText() + "_" + one.calc().toString();
    }
    // Code
}
