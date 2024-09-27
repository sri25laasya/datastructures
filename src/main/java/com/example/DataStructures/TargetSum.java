package com.example.DataStructures;

import java.util.*;

public class TargetSum {
    public List<int[]> findSubarraySum(int[] arr, int targetSum) {
        List<int[]> result = new ArrayList<>();
        int n = arr.length;
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            while (currentSum > targetSum && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == targetSum) {
                result.add(new int[]{start + 1, end + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int targetSum = 23;
        List<int[]> result = solution.findSubarraySum(arr, targetSum);

        for (int[] subarray : result) {
            System.out.println("Subarray: [" + subarray[0] + ", " + subarray[1] + "]");
        }
    }
}