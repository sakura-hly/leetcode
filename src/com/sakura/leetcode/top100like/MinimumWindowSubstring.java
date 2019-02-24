package com.sakura.leetcode.top100like;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        String result = s + " ";

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.

        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {
                char temp = s.charAt(begin);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0)
                        counter++;//modify the counter according the requirement(different condition).
                }

                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                if (end - begin < result.length()) {
                    result = s.substring(begin, end);
                }

                begin++;
            }
        }
        return result.length() == s.length() + 1 ? "" : result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
