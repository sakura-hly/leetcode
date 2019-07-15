package com.sakura.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Pair>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int left = 0, right = list.size(), mid = 0;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (list.get(mid).timestamp > timestamp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == 0 && list.get(left).timestamp <= timestamp) return  list.get(left).value;
        return left == 0 ? null : list.get(left - 1).value;
    }

}
