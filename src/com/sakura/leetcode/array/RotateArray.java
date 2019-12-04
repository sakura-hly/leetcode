package com.sakura.leetcode.array;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || nums.length == 0) return;

        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo++] = nums[hi];
            nums[hi--] = temp;
        }
    }
}
