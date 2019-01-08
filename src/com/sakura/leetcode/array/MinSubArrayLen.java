package com.sakura.leetcode.array;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int result = nums.length;
        boolean flag = false;
        int sum = 0;
        int start = 0, end = 0;

        while (start < nums.length) {
            if (end < nums.length)
                sum += nums[end];

            while (sum >= s) {
                flag = true;
                int temp = end == nums.length ? end - start : end - start + 1;
                result = Math.min(result, temp);
                sum -= nums[start];
                start++;
            }
            if (end == nums.length) {
                start++;
            }
            if (end < nums.length) {
                end++;
            }
        }
        if (flag) {
            return result;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }
}
