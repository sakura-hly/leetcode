package com.sakura.leetcode.array;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = (digits[digits.length - 1] + 1) / 10;
        digits[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (carry == 0) return digits;
            carry = (digits[i] + 1) / 10;
            digits[i] = (digits[i] + 1) % 10;
        }
        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
