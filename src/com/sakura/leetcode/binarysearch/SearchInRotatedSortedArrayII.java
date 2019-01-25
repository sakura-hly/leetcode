package com.sakura.leetcode.binarysearch;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int m = (h - l) / 2 + l;
            if (nums[m] == target) return true;
            if (nums[l] == nums[m]) l++;
            else if (nums[l] < nums[m]) {
                if (nums[l] <= target && target <= nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] <= target && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{1, 3, 5}, 1));
    }
}
