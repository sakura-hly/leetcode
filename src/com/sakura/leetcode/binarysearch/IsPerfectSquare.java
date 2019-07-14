package com.sakura.leetcode.binarysearch;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1, right = num >> 1, mid = 0;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            // mid * mid -> int overflow
            if (num % mid == 0 && num / mid == mid) {
                return true;
            } else if (num / mid <= mid) {
                right = mid - 1;
            } else if (num / mid > mid) {
                left = mid + 1;
            }
        }
        return false;
    }
}
