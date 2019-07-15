package com.sakura.leetcode.binarysearch;

import java.util.Arrays;

public class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for (int house : houses) {
            // binary search to find
            int left = 0, right = heaters.length, mid = 0;
            while (left < right) {
                mid = ((right - left) >> 1) + left;
                if (heaters[mid] == house) {
                    left = mid;
                    break;
                } else if (heaters[mid] < house) {
                    left = mid + 1;
                } else if (heaters[mid] > house) {
                    right = mid;
                }
            }
            if (left == heaters.length) left--;
            else left = heaters[left] == house ? left : left - 1;
            int leftDist = left >= 0 ? house - heaters[left] : Integer.MAX_VALUE;
            int rightDist = left < heaters.length - 1 ? heaters[left + 1] - house : Integer.MAX_VALUE;
            result = Math.max(result, Math.min(leftDist, rightDist));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new FindRadius().findRadius(
                        new int[]{1,2,3,5,15},
                        new int[]{2,30}));
    }
}
