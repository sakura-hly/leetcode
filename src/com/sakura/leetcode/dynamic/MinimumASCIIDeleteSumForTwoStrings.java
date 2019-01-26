package com.sakura.leetcode.dynamic;

public class MinimumASCIIDeleteSumForTwoStrings {

    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        int sum = 0;
        for (int i = 1; i <= len1; i++) {
            sum += s1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s2.charAt(j - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int j = 1; j <= len2; j++) {
            sum += s2.charAt(j - 1);
        }

        return sum - 2 * dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("delete", "leet"));
    }
}
