package com.sakura.array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (true) {
            if (nums[left] > nums[right]) {
                left = left + (right - left) / 2;
            } else {
                left--;
            }
            if (nums[left] > nums[left + 1]) {
                return nums[left + 1];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
