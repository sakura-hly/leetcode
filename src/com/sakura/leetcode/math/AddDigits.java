package com.sakura.leetcode.math;

/**
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
