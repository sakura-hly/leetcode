package com.sakura.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        Map<Character, int[]> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                map.get(chs[i])[1]++;
            } else {
                map.put(chs[i], new int[]{i, 1});
            }
        }

        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>(
                (entry1, entry2) -> {
                    return entry1.getValue()[0] - entry2.getValue()[0];
                }
        );

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == 0) {
                pq.offer(entry);
            }
        }
        return pq.isEmpty() ? -1 : pq.poll().getValue()[0];
    }
}
