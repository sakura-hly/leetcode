package com.sakura.leetcode.dynamic;

import java.util.Arrays;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        // i -> i + nums[0]
//        int[] dp = new int[target - nums[0] + 1];
//        for (int num : nums) {
//            dp[num - nums[0]] = 1;
//        }
//
//        for (int num : nums) {
//            for (int i = 0; i < target - nums[0] + 1; i++) {
//                if (i + num < target - nums[0] + 1)
//                    dp[i + num] += dp[i];
//            }
//        }
//        return dp[target - nums[0]];

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i - num >= 0)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
