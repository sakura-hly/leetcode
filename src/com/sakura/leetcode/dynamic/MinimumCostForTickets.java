package com.sakura.leetcode.dynamic;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        dp[0] = 0;
        dp[1] = Integer.MAX_VALUE;
        for (int cost : costs) dp[1] = Math.min(dp[1], cost);
        for (int i = 2; i <= days.length; i++) {
            int cost0 = dp[i - 1] + costs[0];
            int j = i;
            while (j >= 1 && days[j - 1] > days[i - 1] - 7) j--;
            int cost1 = (j <= 0 ? dp[0] : dp[j]) + costs[1];

            while (j >= 1 && days[j - 1] > days[i - 1] - 30) j--;
            int cost2 = (j <= 0 ? dp[0] : dp[j]) + costs[2];
            dp[i] = Math.min(cost0, Math.min(cost1, cost2));
        }
        return dp[dp.length - 1];
    }
}
