package com.sakura.leetcode.string;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }

            if ((!Character.isDigit(ch) && ' ' != ch) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }

        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate(" 3+5 / 2 "));
    }
}
