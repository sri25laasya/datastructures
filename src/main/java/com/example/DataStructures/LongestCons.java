package com.example.DataStructures;

import java.util.*;

public class LongestCons {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        LongestCons solution = new LongestCons();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestConsecutive = solution.longestConsecutive(nums);
        System.out.println("Longest Consecutive Subsequence: " + longestConsecutive);
    }
}