package com.softserve.crashcourse.session6.example5;

import java.util.Arrays;

public class Appl {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(52645, "Smith");
        students[1] = new Student(98765, "Jones");
        students[2] = new Student(1354, "Johnson");
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].id + " " + students[i].name);
        }
    }
}
