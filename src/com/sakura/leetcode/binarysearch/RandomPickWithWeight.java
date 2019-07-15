package com.sakura.leetcode.binarysearch;

import java.util.Random;

public class RandomPickWithWeight {

    private Random random;
    private int[] sums;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sums[i] = i == 0 ? w[i] : w[i] + sums[i - 1];
        }

    }

    public int pickIndex() {
        int index = random.nextInt(sums[sums.length - 1]) + 1;
        int left = 0, right = sums.length, mid = 0;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (sums[mid] < index) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == sums.length ? left - 1 : left;
    }

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{1, 3});
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
    }

}
