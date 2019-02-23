package com.sakura.leetcode.top100like;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] balloons = new int[n];
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }
        balloons[0] = balloons[nums.length + 1] = 1;

        int[][] dp = new int[n][n];

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = j + i;
                for (int m = j + 1; m < k; m++) {
                    dp[j][k] = Math.max(dp[j][k], dp[j][m] + dp[m][k] + balloons[m] * balloons[j] * balloons[k]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }

    public static void main(String[] args) {
        System.out.println(new BurstBalloons().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
