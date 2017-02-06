package com.softserve.crashcourse.session7.example2;

public class Appl {
    public static void main(String[ ] args) {
        One one = new One( );
        one.setText("data");
        Two two = new Two(one);
        two.resume( );
        // etc
    }
}
