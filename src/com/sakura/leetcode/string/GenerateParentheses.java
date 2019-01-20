package com.sakura.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result, "", n, n);
        return result;
    }

    private void backTrack(List<String> result, String s, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > right) {
            return;
        }
        if (right > 0) {
            backTrack(result, s + ")", left, right - 1);
        }
        if (left > 0) {
            backTrack(result, s + "(", left - 1, right);
        }

    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
