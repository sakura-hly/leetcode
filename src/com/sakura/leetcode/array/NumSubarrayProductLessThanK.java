package com.sakura.leetcode.array;

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int product = 1;

        for (int i = 0, j = 0; j < nums.length; j++) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i++];
            }
            result += j - i + 1;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
