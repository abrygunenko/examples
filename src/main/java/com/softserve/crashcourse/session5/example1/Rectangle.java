package com.softserve.crashcourse.session5.example1;

public class Rectangle extends Figure {
    private double length, width;

    //
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    //
    public double getArea() {
        return length * width;
    }
}
