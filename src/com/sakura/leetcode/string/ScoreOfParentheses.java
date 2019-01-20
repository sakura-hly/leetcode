package com.sakura.leetcode.string;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(-1);
            } else {
                int cur = 0;
                while (stack.peek() != -1) {
                    cur += stack.pop();
                }

                stack.pop();
                stack.push(cur == 0 ? 1 : cur * 2);
            }
        }

        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()(()))"));
    }
}
