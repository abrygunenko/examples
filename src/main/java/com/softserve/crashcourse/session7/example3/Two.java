package com.softserve.crashcourse.session7.example3;

public class Two {
    private IOne one;

    public Two(IOne one) {
        this.one = one;
    }

    public String resume() {
        // Functionality
        return one.getText() + "_" + one.calc().toString();
    }
    // Code
}
