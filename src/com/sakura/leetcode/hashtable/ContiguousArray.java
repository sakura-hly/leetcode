package com.sakura.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int balance = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            balance += nums[i] * 2 - 1; // -1, 1
            // sum(first:i-1) = 0
            Integer first = map.putIfAbsent(balance, i);

            if (first != null) {
                result = Math.max(result, i - first);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 1, 0}));
    }

}
