package com.sakura.leetcode.array;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int minSum = 0;
        int maxSum = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int a : A) {
            sum += a;

            minSum += a;
            maxSum += a;
            min = Math.min(min, minSum);
            max = Math.max(max, maxSum);

            if (minSum > 0) minSum = 0;
            if (maxSum < 0) maxSum = 0;
        }
        if (max < 0) return max;
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{5, -3, 5}));
    }
}
