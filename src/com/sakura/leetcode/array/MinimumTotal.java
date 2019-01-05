package com.sakura.leetcode.array;

import java.util.List;

public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];

        List<Integer> bottom = triangle.get(len - 1);
        for (int j = 0; j < bottom.size(); j++) {
            dp[j] = bottom.get(j);
        }

        for (int i = len - 2; i >= 0; i--) {
            List<Integer> help = triangle.get(i);
            for (int j = 0; j < help.size(); j++) {
                dp[j] = help.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
    }
}
