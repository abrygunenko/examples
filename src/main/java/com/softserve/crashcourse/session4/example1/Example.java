package com.softserve.crashcourse.session4.example1;

public class Example {

    private static int k = 22;
    private static Integer l = 33;
    private static Integer m = 33;
    private static Integer o = new Integer(33);
    private int i = 11;

    public static void main(String[] args) {
        if (l.equals(o)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static void sayHello() {
        System.out.println("Hello!");
    }

    private void saySomething() {
        System.out.println("My first program");
        System.out.println("j: " + k);
        System.out.println("j: " + l);
        Example main = new Example();
        System.out.println("i: " + main.i);

        sayHello();
        main.saySomething();
        System.out.println("Something");
    }

    private Example() {

    }
}
