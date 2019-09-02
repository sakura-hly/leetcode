package com.sakura.leetcode.dynamic;

public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int x = 0, y = 0, z = 0;
        for (int i = 1; i < n; i++) {
            int num = Math.min(dp[x] * 2, Math.min(dp[y] * 3, dp[z] * 5));
            if (num == dp[x] * 2) x++;
            if (num == dp[y] * 3) y++;
            if (num == dp[z] * 5) z++;
            dp[i] = num;
        }
        return dp[n - 1];
    }
    
}
