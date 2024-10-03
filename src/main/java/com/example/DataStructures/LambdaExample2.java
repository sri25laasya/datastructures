package com.example.DataStructures;

import java.util.Arrays;
import java.util.List;

public class LambdaExample2 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Running in a thread using Lambda");
        Thread thread = new Thread(runnable);
        thread.start();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
               .filter(n -> n % 2 == 0) 
               .forEach(n -> System.out.println("Even number: " + n));
        
        numbers.forEach(n -> System.out.println("Number: " + n));
    }
}
