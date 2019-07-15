package com.sakura.leetcode.binarysearch;

import java.util.Arrays;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = Arrays.copyOf(intervals[i], intervals[i].length + 1);
            intervals[i][intervals[i].length - 1] = i;
        }
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int left = 0, right = intervals.length, mid = 0;
            while (left < right) {
                mid = ((right - left) >> 1) + left;
                if (intervals[mid][0] >= intervals[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[intervals[i][2]] = left == intervals.length || left == i ? -1 : intervals[left][2];
        }
        return res;
    }

}
