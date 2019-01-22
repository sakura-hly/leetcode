package com.sakura.leetcode.string;


public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int flag = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        if (flag == 0) return true;
        flag = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }
}
