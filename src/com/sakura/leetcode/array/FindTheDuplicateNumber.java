package com.sakura.leetcode.array;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
