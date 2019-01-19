package com.sakura.leetcode.twopointers;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String str : d) {
            int p1 = 0, p2 = 0;
            while (p1 < s.length() && p2 < str.length()) {
                if (s.charAt(p1) == str.charAt(p2)) {
                    p2++;
                }
                p1++;
            }
            if (p2 == str.length()) {
                if (p2 > result.length() || (p2 == result.length() && str.compareTo(result) < 0)) {
                    result = str;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord("abpcplea", list));
    }
}
