package com.sakura.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/relative-ranks/
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) map.put(nums[i], nums.length - i);
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums.length >= 3 && copy[i] == nums[nums.length - 3])
                ss[i] = "Bronze Medal";
            else if (nums.length >= 2 && copy[i] == nums[nums.length - 2])
                ss[i] = "Silver Medal";
            else if (nums.length >= 1 && copy[i] == nums[nums.length - 1])
                ss[i] = "Gold Medal";
            else ss[i] = String.valueOf(map.get(copy[i]));
        }
        return ss;
    }

}
