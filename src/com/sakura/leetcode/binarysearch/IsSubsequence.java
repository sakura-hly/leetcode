package com.sakura.leetcode.binarysearch;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int p1 = 0, p2 = 0;
        for (; p2 < t.length(); p2++) {
            if (p1 == s.length()) return true;
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
        }

        return p1 == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
    }
}
