package com.sakura.leetcode.top100like;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        int size = getSize(nums.length);
        List<List<Integer>> result = new ArrayList<>(size);
        if (nums == null || nums.length == 0) return result;
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private int getSize(int length) {
        int result = length;
        while (--length > 0) {
            result *= length;
        }
        return result;
    }

    private void backTrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int start) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(result, temp, nums, 0);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
    }
}
