package com.softserve.crashcourse.session6.example1;

public class Appl {
    public static void main(String[] args) {
        String text = "Hello World";
//        SimpleBox box = new SimpleBox();
//        WrapperBox box = new WrapperBox();
        Box<String> box = new Box<String>();
        box.set(text);
//        Integer i = (Integer) box.get();
    }
}
