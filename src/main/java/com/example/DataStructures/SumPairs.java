package com.example.DataStructures;

import java.util.Arrays;

public class SumPairs {
    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 6, 1, 4};
        int target = 10;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] result = findPair(arr, target);
        if (result != null) {
            System.out.println("Pair found at indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("Pair not found");
        }
    }

    public static int[] findPair(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
