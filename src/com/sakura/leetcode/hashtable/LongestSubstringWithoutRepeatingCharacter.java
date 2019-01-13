package com.sakura.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        int result = 0, len = s.length();
        if (len <= 1) {
            return len;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < len; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring("aab"));
    }
}
