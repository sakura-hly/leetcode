package com.sakura.leetcode.array;

import java.util.*;

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * create by: sakura
     * description: TODO
     *
     * @return
     * @Param: null
     */
    private void backTrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int i) {
        result.add(new ArrayList<>(temp));
        if (i == nums.length) {
            return;
        } else {
            for (int j = i; j < nums.length; j++) {
                temp.add(nums[j]);
                backTrack(result, temp, nums, j + 1);
                temp.remove(temp.size() - 1);

                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
