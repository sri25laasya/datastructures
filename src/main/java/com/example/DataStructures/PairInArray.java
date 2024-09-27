package com.example.DataStructures;

import java.util.*;

public class PairInArray {
    public boolean findPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        PairInArray solution = new PairInArray();
        int[] arr = {2, 7, 5, 6, 1, 4};
        int target = 10;
        boolean result = solution.findPair(arr, target);

        if (result) {
            System.out.println("Pair found");
        } else {
            System.out.println("Pair not found");
        }
    }
}
