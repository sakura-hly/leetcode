package com.sakura.leetcode.top100like;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] help = new int[123 - 65  + 1];
        for (char c : t.toCharArray()) help[c - 'A']++;
        int count = t.length(), start = 0, end = 0;
        int begin = 0, len = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (help[s.charAt(end++) - 'A']-- > 0) count--;
            while (count == 0) {
                if (end - start < len) {
                    begin = start;
                    len = end - start;
                }
                if (help[s.charAt(start++) - 'A']++ >= 0) count++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(begin, begin + len);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
