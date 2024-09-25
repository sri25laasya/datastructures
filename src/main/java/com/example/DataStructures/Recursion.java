package com.example.DataStructures;

public class Recursion {
    public static void printCohort(int n) {
        if (n > 0) {
            System.out.println("Cohort401");
            printCohort(n-1);
        }
    }

    public static void main(String[] args) {
        printCohort(5); 
    }
}
