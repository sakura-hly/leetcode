package com.sakura.leetcode.string;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) return false;
        int len = s.length();
        for (int l = 1; l <= (len >> 1); l++) {
            if (len % l != 0) continue;
            int i = l;
            for (; i < len; i += l) {
                if (!s.substring(i, i + l).equals(s.substring(0, l))) break;
            }
            if (i == len) return true;
        }
        return false;
    }
}
