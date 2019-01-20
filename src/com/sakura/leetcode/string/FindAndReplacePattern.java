package com.sakura.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new LinkedList<>();

        for (String word : words) {
            // word -> pattern
            int[] w = new int[256];
            // pattern -> word
            int[] p = new int[256];
            result.add(word);
            for (int i = 0; i < word.length(); i++) {
                if (p[pattern.charAt(i)] != w[word.charAt(i)]) {
                    result.remove(result.size() - 1);
                    break;
                } else {
                    p[pattern.charAt(i)] = w[word.charAt(i)] = i + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAndReplacePattern().findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
