package com.sakura.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return KSum(nums, target, 4, 0);
    }

    private List<List<Integer>> KSum(int[] nums, int target, int K, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (start >= nums.length) {
            return result;
        }
        if (K == 2) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    result.add(temp);
                    //skip duplication
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> temp = KSum(nums, target - nums[i], K - 1, i + 1);
                if (temp != null) {
                    for (List<Integer> list : temp) {
                        list.add(0, nums[i]);
                    }
                    result.addAll(temp);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    //skip duplication
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
