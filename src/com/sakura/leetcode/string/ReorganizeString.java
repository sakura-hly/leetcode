package com.sakura.leetcode.string;

import java.util.*;

public class ReorganizeString {

    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> last = null;
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);

            if (last != null) {
                queue.offer(last);
            }

            last = entry.getValue() > 0 ? entry : null;
        }

        return sb.length() == S.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aaab"));
    }
}
