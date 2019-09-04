package com.sakura.leetcode.greedy;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (int[] cost1, int[] cost2) -> {
            return (cost1[0] - cost1[1]) - (cost2[0] - cost2[1]);
        });
        
        int res = 0;
        for (int i = 0; i < (costs.length >> 1); i++) {
            res += costs[i][0];
            res += costs[costs.length - 1 - i][1];
        }
        return res;
        
    }
}