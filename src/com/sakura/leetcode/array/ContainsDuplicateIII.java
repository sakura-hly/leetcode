package com.sakura.leetcode.array;

import java.util.TreeSet;

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = treeSet.floor(Long.valueOf(nums[i]) + t);
            Long ceil = treeSet.ceiling(Long.valueOf(nums[i]) - t);
            if ((floor != null && floor >= nums[i])|| (ceil != null && ceil <= nums[i])) return true;
            treeSet.add(Long.valueOf(nums[i]));
            if (i >= k) treeSet.remove(Long.valueOf(nums[i - k]));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647}, 3, 3));
    }
}
