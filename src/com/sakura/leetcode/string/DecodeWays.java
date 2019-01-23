package com.sakura.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class DecodeWays {
    /* backTrack: Memory Limit Exceeded、Time Limit Exceeded

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<List<Integer>> result = new LinkedList<>();
        backTrack(result, new LinkedList<>(), s, 0);

        return result.size();
    }

    private void backTrack(List<List<Integer>> result, LinkedList<Integer> temp, String s, int start) {
        if (start == s.length()) {
            result.add(new LinkedList<>(temp));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < s.length(); i++) {
                sb.append(s.charAt(i));
                Integer num = Integer.valueOf(sb.toString());
                if (num < 1 || num > 26) {
                    break;
                }
                temp.add(num);
                backTrack(result, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    */

    public int numDecodings(String s) {
        /*********************DP*****************************/
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == '0' && (s.charAt(i - 2) == '0' || s.charAt(i - 2) - '0' > 2)) {
                return 0;
            }
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) != '0' && valid(Integer.valueOf(s.substring(i - 2, i)))) {
                dp[i] += dp[i - 2];
            }

        }
        return dp[len];
    }

    private boolean valid(int num) {
        return num >= 1 && num <= 26;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("101"));
    }
}
