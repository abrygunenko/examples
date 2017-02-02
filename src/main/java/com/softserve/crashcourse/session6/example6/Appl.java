package com.softserve.crashcourse.session6.example6;

public class Appl {
    public static void main(String[] args) {
        int i;
        char s[] = {'J', 'a', 'v', 'a'};
        String str = new String(s);                // str="Java"
        if (!str.isEmpty()) {
            i = str.length();                            // i=4
            str = str.toUpperCase();                // str="JAVA"
            String num = String.valueOf(8);     // num=“8"

            num = str.concat("-" + num);        // num="JAVA-8"
            char ch = str.charAt(2);                 // ch='V'
            i = str.lastIndexOf('A');                  // i=3 or -1
            num = num.replace("8", "SE");      // num="JAVA-SE"
            str.substring(0, 4).toLowerCase();  // java
            str = num + "-8";                          // str="JAVA-SE-8"
            String[] arr = str.split("-");
            for (String ss : arr) {
                System.out.println(ss);
            }
        }
    }
}
