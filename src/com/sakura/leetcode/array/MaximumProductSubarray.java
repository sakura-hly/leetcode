package com.sakura.leetcode.array;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int min = nums[0], max = nums[0], maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(min * nums[i], Math.max(max * nums[i], nums[i]));
            min = Math.min(min * nums[i], Math.min(temp * nums[i], nums[i]));

            maxProduct = Math.max(max, maxProduct);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-4, -3, -2}));
    }
}
