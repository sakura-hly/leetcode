package com.sakura.leetcode.array;

public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int[] buy = new int[len], sell = new int[len];
        buy[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            // keep the same as day i-1, or buy from sell status at day i-1
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            // keep the same as day i-1, or sell from buy status at day i-1
            sell[i] = Math.max(buy[i - 1] + prices[i] - fee, sell[i - 1]);
        }
        return sell[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
