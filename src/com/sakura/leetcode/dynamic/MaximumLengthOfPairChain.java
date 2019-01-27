package com.sakura.leetcode.dynamic;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = dp[j];
                if (pairs[i][0] > pairs[j][1]) {
                    temp++;
                }
                dp[i] = Math.max(dp[i], temp);
            }
        }

        return dp[pairs.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}
