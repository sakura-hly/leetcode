package com.sakura.leetcode.dynamic;

public class LargestSumOfAverages {

    public double largestSumOfAverages(int[] A, int K) {
        // sum(1 -> i)
        double[] sum = new double[A.length + 1];
        // avg(i -> A.length)
        double[] dp = new double[A.length + 1];
        for (int i = 1; i < A.length + 1; i++) {
            sum[i] = sum[i - 1] + A[i - 1];

        }
        for (int i = 1; i < A.length + 1; i++) {
            dp[i] = (sum[A.length] - sum[i - 1]) / (A.length - i + 1);
        }
        for (int k = 2; k < K + 1; k++) {
            for (int i = 1; i < A.length + 1; i++) {
                for (int j = i + 1; j < A.length + 1; j++) {
                    dp[i] = Math.max(dp[i], dp[j] + (sum[j - 1] - sum[i - 1]) / (j - i));
                }
            }
        }

        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumOfAverages().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }
}
