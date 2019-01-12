package com.sakura.leetcode.hashtable;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || k == 0) {
            return new ArrayList<>(0);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            int minus = o2.getValue() - o1.getValue();
            if (minus != 0) {
                return minus;
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        List<String> result = new ArrayList<>(k);
        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
            if (result.size() == k) {
                break;
            }
        }

        return result;
    }
}
