package com.sakura.leetcode.array;

public class NumMatchingSubseq {

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        if (S == null || words == null)
            return count;

        for (String word : words) {
            int i = 0;
            int j = 0;
            while (i < S.length() && j < word.length()) {
                if (S.charAt(i) == word.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == word.length()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumMatchingSubseq().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
