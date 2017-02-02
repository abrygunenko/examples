package com.softserve.crashcourse.session6.example2;

public class Appl {
    public static void main(String[] args) {
        Car[]cars1;                // null reference
        Car[]cars2=new Car[10];    // null references
        for(int i=0;i<cars2.length;i++){
            cars2[i]=new Car();
        }

        // Aggregated initialization
        Car[]cars3={new Car(),new Car(),new Car(),new Car()};
        cars1= new Car[]{new Car(), new Car(), new Car()};
    }
}
