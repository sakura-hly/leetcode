package com.sakura.leetcode.dynamic;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum < S || -totalSum > S) return 0;

        // dp[i] -> the number of ways to have sum = i - totalSum
        int[] dp = new int[2 * totalSum + 1];
        // We start from no elements in the array, so there is one way to have sum = 0 that there is no element
        dp[totalSum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * totalSum + 1];
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                if (j - nums[i] > 0) next[j - nums[i]] += dp[j];
                if (j + nums[i] < 2 * totalSum) next[j + nums[i]] += dp[j];
            }

            dp = next;
        }
        return dp[totalSum + S];
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
