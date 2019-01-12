package com.sakura.leetcode.hashtable;

import java.util.*;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new ArrayList<>(0);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> result = new ArrayList<>(k);
        for (Map.Entry<Integer, Integer> entry : list) {
            result.add(entry.getKey());
            if (result.size() == k) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
