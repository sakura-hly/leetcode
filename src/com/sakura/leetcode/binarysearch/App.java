package com.sakura.leetcode.binarysearch;

import java.util.*;

public class App {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) map1.put(num, map1.getOrDefault(num, 0) + 1);
        for (int num : nums2) map2.put(num, map2.getOrDefault(num, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
                while (count-- > 0) list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
