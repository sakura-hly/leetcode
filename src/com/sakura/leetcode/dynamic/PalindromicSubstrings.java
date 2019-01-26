package com.sakura.leetcode.dynamic;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = getResult(s, result, i, i);//Count even sized
            result = getResult(s, result, i, i + 1);//Count odd sized
        }
        return result;
    }

    private int getResult(String s, int result, int i, int j) {
        // 从i, j开始向两边扩散
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            result++;
            i--;
            j++;
        }
        return result;
    }


    public static boolean IsPalindromic(String s) {
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (!(s.charAt(i) == s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
    }
}
