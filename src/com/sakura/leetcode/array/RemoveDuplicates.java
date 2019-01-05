package com.sakura.leetcode.array;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        int[] help = new int[nums[nums.length - 1] - nums[0] + 1];

        int move = 0;
        for (int i = 0; i < nums.length - move; ) {
            if (i > 0 && nums[i] < nums[i - 1]) {
                break;
            }

            int index = nums[i] - nums[0];
            if (help[index] < 2) {
                help[index] += 1;
                i++;
            } else {
                System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
                move++;
                nums[nums.length - 1] = index + nums[0];
            }
        }

        int result = 0;
        for (int i : help) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1, 1, 1}));
    }
}
