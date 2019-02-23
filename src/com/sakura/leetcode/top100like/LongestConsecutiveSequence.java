package com.sakura.leetcode.top100like;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int result = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int count = 1;
                set.remove(num);
                int val = num;
                while (set.remove(--val)) count++;
                val = num;
                while (set.remove(++val)) count++;

                result = Math.max(result, count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
