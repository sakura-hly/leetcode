package com.sakura.dynamic;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + piles[i - 1];
        }

        int[][] dp = new int[len][len];
        for (int size = 1; size < len; size++) {
            for (int i = 0; i + size < len; i++) {
                dp[i][i + size] = Math.max(sum[i + size + 1] - sum[i] - dp[i + 1][i + size], sum[i + size + 1] - sum[i] - dp[i][i + size - 1]);
            }
        }
        return dp[0][len - 1] * 2 > sum[len];
    }

    public static void main(String[] args) {
        System.out.println(new StoneGame().stoneGame(new int[]{5, 3, 4, 5}));
    }
}
