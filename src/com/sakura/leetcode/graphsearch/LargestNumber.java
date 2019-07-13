package com.sakura.leetcode.graphsearch;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    private String res = "";

    public String largestNumber(int[] nums) {
        if (checkZero(nums)) return "0";
        Arrays.sort(nums);
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
//        boolean[] visited = new boolean[nums.length];
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }

    private boolean checkZero(int[] nums) {
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }

    private void dfs(String[] strs, boolean[] visited, StringBuilder sb, int maxLen) {
        if (sb.length() == maxLen) {
            if (sb.toString().compareTo(res) > 0) {
                res = sb.toString();
            }
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int len = sb.length();
                sb.append(strs[i]);

                dfs(strs, visited, sb, maxLen);

                sb.setLength(len);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3, 30}));
        System.out.println(new LargestNumber().largestNumber(new int[]{128, 12}));
        System.out.println(new LargestNumber().largestNumber(new int[]{121, 12}));
    }
}
