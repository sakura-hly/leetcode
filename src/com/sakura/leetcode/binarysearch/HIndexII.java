package com.sakura.leetcode.binarysearch;

public class HIndexII {

    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1, mid = 0;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] < citations.length - mid) {
                left = mid + 1;
            } else if (citations[mid] > citations.length - mid) {
                right = mid - 1;
            }
        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        System.out.println(new HIndexII().hIndex(new int[]{0, 1, 3, 5, 6}));
    }
}
