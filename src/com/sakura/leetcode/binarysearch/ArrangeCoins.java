package com.sakura.leetcode.binarysearch;

public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int left = 0, right = n, mid = 0, even = 0, odd = 0;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            even = (mid & 1) == 0 ? mid : mid + 1;
            odd = (mid & 1) == 0 ? mid + 1 : mid;
            if (n % odd == 0 && n / odd == (even >> 1)) {
                return mid;
            } else if (n / odd > (even >> 1)) {
                left = mid + 1;
            } else if (n / odd <= (even >> 1)) {
                right = mid;
            }
        }
        even = (left & 1) == 0 ? left : left + 1;
        odd = (left & 1) == 0 ? left + 1 : left;
        if (n / odd >= (even >> 1)) {
            return left;
        } else {
            return left - 1;
        }
        
    }

    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins(2147483647));
    }
}
