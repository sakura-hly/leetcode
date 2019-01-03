package com.sakura.leetcode.array;


public class SortColors {

    public void sortColors(int[] nums) {
        // fisrt 1
        int left = 0;
        // first non-2
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;

                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;

                right--;
            }
        }
    }

    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
