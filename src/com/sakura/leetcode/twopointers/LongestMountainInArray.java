package com.sakura.leetcode.twopointers;

public class LongestMountainInArray {

    public int longestMountain(int[] A) {
        int[] up = new int[A.length], down = new int[A.length];

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                down[i] = down[i + 1] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] > A[i - 1]) {
                up[i] = up[i - 1] + 1;
            }
            if (up[i] > 0 && down[i] > 0)
                result = Math.max(result, up[i] + down[i] + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestMountainInArray().longestMountain(new int[]{2, 2, 2}));
    }
}
