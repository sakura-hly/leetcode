package com.sakura.leetcode.dynamic;


public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] help = new int[10001];
        for (int num : nums) {
            help[num] += num;
        }

        int take = 0, skip = 0;
        for (int i = 0; i < 10001; i++) {
            int take_i = skip + help[i];
            int skip_i = Math.max(take, skip);
            take = take_i;
            skip = skip_i;
        }
        return Math.max(take, skip);
    }

    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
