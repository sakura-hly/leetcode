package com.sakura.leetcode.top100like;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int n = s.length(), start = 0, result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, i - start + 1);
                    } else {
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()()"));
    }
}
