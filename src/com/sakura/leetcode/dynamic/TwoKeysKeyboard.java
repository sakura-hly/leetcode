package com.sakura.leetcode.dynamic;

public class TwoKeysKeyboard {

    public int minSteps(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];
        // 质数为 i
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i >> 1; j >= 2; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new TwoKeysKeyboard().minSteps(3));
    }
}
