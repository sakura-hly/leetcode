package com.sakura.leetcode.binarysearch;

import java.util.Random;

public class RandomPointInNonOverlappingRectangles {

    private Random random;
    private int[] sums;
    private int[][] rects;

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        random = new Random();
        this.rects = rects;
        sums = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            sums[i] = i == 0
                    ? (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1)
                    : (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1) + sums[i - 1];
        }
    }

    public int[] pick() {
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
        if (left == sums.length) left--;

        int count = left == 0 ? sums[left] : sums[left] - sums[left - 1];
        int rect_index = random.nextInt(count);
        int rect_long = rects[left][2] - rects[left][0] + 1;
        return new int[]{rects[left][0] + rect_index % rect_long, rects[left][1] + rect_index / rect_long};
    }
}
