package com.sakura.leetcode.hashtable;

import java.util.*;
import java.util.function.Consumer;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());

        list.forEach(entry -> {
            Character key = entry.getKey();
            Integer count = entry.getValue();
            while (count-- > 0) {
                sb.append(key);
            }
        });


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
    }
}
