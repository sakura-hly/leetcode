package com.sakura.leetcode.contest131;

import java.util.Stack;

public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int begin = -1, end = -1;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() && S.charAt(i) == '(') {
                stack.push('(');
                begin = i;
            } else if (S.charAt(i) == '(') {
                stack.push('(');
            } else if (S.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    end = i;
                }
            }
            if (begin >= 0 && end >= 0 && begin <= end)
                result.append(S.substring(begin + 1, end));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveOuterParentheses().removeOuterParentheses("(()())(())"));
    }
}
