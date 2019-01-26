package com.sakura.leetcode.divideandconquer;

import java.util.LinkedList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char sign = input.charAt(i);
            if (sign == '-' || sign == '+' || sign == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int i1 : left) {
                    for (int i2 : right) {
                        if (sign == '-')
                            result.add(i1 - i2);
                        if (sign == '+')
                            result.add(i1 + i2);
                        if (sign == '*')
                            result.add(i1 * i2);
                    }
                }

            }

        }
        if (result.size() == 0) result.add(Integer.valueOf(input));
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5"));
    }
}
