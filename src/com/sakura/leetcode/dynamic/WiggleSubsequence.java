package com.sakura.leetcode.dynamic;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // sign
        dp[0][1] = 1; // len

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] == nums[j] || (nums[i] - nums[j]) * dp[j][0] > 0)
                        && dp[i][1] == 0) {
                    dp[i][0] = 0;
                    dp[i][1] = 1;
                } else if ((nums[i] != nums[j] && dp[j][0] == 0)
                        || (nums[i] - nums[j]) * dp[j][0] < 0) {
                    if (dp[i][1] < dp[j][1] + 1) {
                        dp[i][0] = nums[i] - nums[j];
                        dp[i][1] = dp[j][1] + 1;
                    }
                }
            }
        }
        return dp[n - 1][1];
    }
}
