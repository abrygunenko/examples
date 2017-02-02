package com.softserve.crashcourse.session5.example3;

public class ApplAB {
    public static void main(String[] args) {
        System.out.println("The Start.");
//        Integer num = 1;
//        Double data = 1.0;
//        data = num.doubleValue();
//        num = data.intValue();
//        System.out.println("data=" + data);
//        System.out.println("num=" + num);

        ClassA a = new ClassA();
        ClassA b = new ClassB();
        System.out.println("Test ClassA.");
        a.m1();
        a.m2();
        a.m3();
        a.m4();
        System.out.println("Test ClassB.");
        b.m1();
        b.m2();
        b.m3();
        b.m4();

        ClassB b1 = new ClassB();
        System.out.println("Test_1 ClassB.");
        b1.m1();
        b1.m2();
        b1.m3();
        b1.m4();
        System.out.println("The End.");
    }
}
