package com.softserve.crashcourse.session5.example4;

public class BmwX6mod extends BmwX6 {
    public BmwX6mod() {
        super(230);
    }

    @Override
    public void checkEngine() {
        System.out.println("BmwX6mod: Engine is running on Diesel.");
        System.out.println("BmwX6mod: Max Speed: " + getMaxSpeed());
    }

    @Override
    public void checkLights() {
        System.out.println("BmwX6mod: Xenon Headlights.");
        super.checkLights();
    }
}
