package com.sakura.leetcode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    private Map<String, Integer> map;// s -> count
    private Map<Integer, Set<String>> lists; // count -> list of s
    private int min, max;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
        lists = new HashMap<>();
        lists.put(0, new HashSet<>());
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        int count = map.getOrDefault(key, 0) + 1;
        if (count > 1) lists.get(count - 1).remove(key);
        if (max == count - 1) max++;
        if (min == count - 1 && lists.get(count - 1).size() == 0) {
            min++;
        } else {
            min = Math.min(min, count);
        }
        if (!lists.containsKey(count)) lists.put(count, new HashSet<>());
        lists.get(count).add(key);
        map.put(key, count);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        int count = map.get(key);
        lists.get(count).remove(key);
        if (max == count && lists.get(count).size() == 0) max--;
        if (min == count && lists.get(count).size() == 0) min--;
        // add a patch ~_~
        if (min == 0 && map.size() > 0) {
            while (true) {
                min++;
                if (lists.get(min).size() > 0) break;;
            }
        }
        if (count - 1 > 0) {
            lists.get(count - 1).add(key);
            map.put(key, count - 1);
        } else {
            map.remove(key);
        }

    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return max == 0 ? "" : lists.get(max).iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return min == 0 ? "" : lists.get(min).iterator().next();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
