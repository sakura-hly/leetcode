package com.sakura.dynamic;

import java.util.Arrays;

/*
Input: 5
Output: [0,1,1,2,1,2]
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
    }
}
