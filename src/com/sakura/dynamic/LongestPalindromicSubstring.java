package com.sakura.dynamic;

/*
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String result = null;
        int len = s.length();
        //substring(i,j) is panlidrome
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (result == null || j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaa"));
    }
}
