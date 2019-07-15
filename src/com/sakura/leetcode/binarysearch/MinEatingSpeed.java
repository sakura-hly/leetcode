package com.sakura.leetcode.binarysearch;

public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int H) {
        int maxPile = 0;
        for (int pile : piles) maxPile = Math.max(maxPile, pile);
        int left = 1, right = maxPile + 1, mid = 0;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (enough(piles, H, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == maxPile + 1 ? maxPile : left;
    }

    private boolean enough(int[] piles, int H, int K) {
        int count = 0;
        for (int pile : piles) {
            int temp = pile / K;
            count += pile % K == 0 ? temp : temp + 1;
        }
        return count <= H;
    }

    public static void main(String[] args) {
        System.out.println(new MinEatingSpeed().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}
