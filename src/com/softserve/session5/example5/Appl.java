package com.softserve.session5.example5;

public class Appl {
    public static void main(String[] args) {
        Grandchild g = new Grandchild();
        boolean result = (g.f( ) == g.y( ));   // ???
        System.out.println("result=" + result);
    }
}
