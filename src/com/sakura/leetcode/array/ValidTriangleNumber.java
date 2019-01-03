package com.sakura.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTriangleNumber {
    /**************************************Time Limit Exceeded****************************************************/
    public int triangleNumber_TLE(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums, 0);
        return result.size();
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        if (temp.size() == 3 && !IsValidTriang(temp)) {
            return;
        } else if (temp.size() == 3 && IsValidTriang(temp)) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backTrack(result, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private boolean IsValidTriang(List<Integer> temp) {
        if (temp.get(0) + temp.get(1) > temp.get(2)
                && temp.get(0) + temp.get(2) > temp.get(1)
                && temp.get(1) + temp.get(2) > temp.get(0)) {
            return true;
        }
        return false;
    }


    public int triangleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] temp = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                temp[index++] = num;
            }
        }
        if (temp[temp.length - 1] == 0) {
            temp = Arrays.copyOf(temp, temp.length - 1);
        }
        if (temp.length < 3) {
            return 0;
        }
        Arrays.sort(temp);
        int result = 0;
        for (int i = temp.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (temp[left] + temp[right] > temp[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
