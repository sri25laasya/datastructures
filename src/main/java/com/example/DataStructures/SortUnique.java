package com.example.DataStructures;
import java.util.*;

public class SortUnique {
    public static int separateUniqueElements(int[] arr) {
        Set<Integer> uniqueElements = new HashSet<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!uniqueElements.contains(arr[i])) {
                uniqueElements.add(arr[i]);
                arr[index++] = arr[i];
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 4, 5, 6, 6, 7, 7, 8};
        int uniqueCount = separateUniqueElements(arr);
        System.out.println("Number of unique elements: " + uniqueCount);
        System.out.print("Modified array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
