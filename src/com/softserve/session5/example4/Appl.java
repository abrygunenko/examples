package com.softserve.session5.example4;

public class Appl {
    public static void main(String[] args) {
        Car carX6 = new BmwX6();
        Car carX6mod = new BmwX6mod();
        BmwX6 carX6mod2 = new BmwX6mod();
        carX6.systemCheck();
        ((BmwX6) carX6).checkLights();
        carX6mod.systemCheck();
        ((BmwX6) carX6mod).checkLights();
        carX6mod2.systemCheck();
        carX6mod2.checkLights();
    }
}
