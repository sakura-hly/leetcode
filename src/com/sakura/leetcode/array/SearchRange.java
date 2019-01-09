package com.sakura.leetcode.array;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int start = -1, end = -1;
        while (l <= r) {
            int m = (l - r) / 2 + r;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                start = m;
                end = m;
                int i = m;
                while (--i >= 0) {
                    if (nums[i] == target) {
                        start = i;
                    }
                }
                i = m;
                while (++i < nums.length) {
                    if (nums[i] == target) {
                        end = i;
                    }
                }
                break;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        System.out.println(new SearchRange().searchRange(new int[]{1}, 1));
    }
}
