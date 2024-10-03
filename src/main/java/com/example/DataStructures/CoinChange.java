package com.example.DataStructures;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Create a DP array of size (amount + 1) initialized with a large value
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // 0 coins are needed to make amount 0

        // Iterate through each coin
        for (int coin : coins) {
            // For each coin, update all the amounts that can be formed
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still greater than amount, return -1 (no solution)
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println("Minimum coins needed: " + cc.coinChange(coins, amount));  // Output: 3 (5+5+1)
    }
}

