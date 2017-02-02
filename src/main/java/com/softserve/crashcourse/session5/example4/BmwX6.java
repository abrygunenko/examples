package com.softserve.crashcourse.session5.example4;

public class BmwX6 extends Car {
    public BmwX6() {
        this(200);
    }

    public BmwX6(double maxSpeed) {
        setMaxSpeed(maxSpeed);
    }

    @Override
    public void systemCheck() {
//        setMaxSpeed(200);
        System.out.println("System check");
        checkEngine();
        checkGearBox();
    }

    public void checkEngine() {
        System.out.println("BmwX6: Engine is running on Petrol.");
        System.out.println("BmwX6: Max Speed: " + getMaxSpeed());
    }

    private void checkGearBox() {
        System.out.println("BmwX6: Working GearBox.");
    }

    public void checkLights() {
        System.out.println("BmwX6: Halogen Headlights.");
    }
}
