package com.sakura.leetcode.math;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        int result = 0;

        while (i < j) {
            result += nums[j] - nums[i];
            i++;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(new int[]{1, 2, 3}));
    }
}
