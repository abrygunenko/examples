package com.softserve.crashcourse.session6.example1;

public class Box<T> {
    // T stands for "Type".
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
