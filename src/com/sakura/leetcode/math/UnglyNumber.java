package com.sakura.leetcode.math;

/**
 * https://leetcode.com/problems/ugly-number/
 */
public class UnglyNumber {
    public boolean isUgly(int num) {
        while (num != 0 && num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return num == 1;
    }
}
