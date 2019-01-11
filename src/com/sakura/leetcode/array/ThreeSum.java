package com.sakura.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == 0 - nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[j] + nums[k] > 0 - nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}
