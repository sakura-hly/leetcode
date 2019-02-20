package com.sakura.leetcode.top100like;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null ||s.length() == 0) return "";
        Stack<Integer> number = new Stack<>();
        Stack<String> string = new Stack<>();
        string.push("");
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                number.push(Integer.valueOf(s.substring(start, i + 1)));
            } else if (ch == '[') {
                string.push("");
            } else if (ch == ']') {
                String temp = string.pop();
                int count = number.pop();
                StringBuilder sb = new StringBuilder();
                while (count-- > 0) {
                    sb.append(temp);
                }
                string.push(string.pop() + sb.toString());
            } else {
                string.push(string.pop() + ch);
            }
        }

        return string.pop();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }
}
