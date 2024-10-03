package com.example.DataStructures;

import java.util.function.Function;
import java.util.Scanner;

public class LambdaExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        Function<String, String> toUpper = str -> str.toUpperCase();
        String result = toUpper.apply(input);
        System.out.println("Uppercase: " + result);
        scanner.close();
    }
}

    