package com.sakura.leetcode.binarysearch;

public class MySqrt {

    public int mySqrt(int x) {
        if (x < 0) return Integer.MIN_VALUE;
        if (x <= 1) return x;
        int left = 1, right = x >> 1, mid = 0;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (x / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return x / left >= left ? left : left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(Integer.MAX_VALUE));
    }
}
