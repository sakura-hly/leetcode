package com.sakura.leetcode.array;

public class CanJump {

    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (maxJump < i) {
                return false;
            }

            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
