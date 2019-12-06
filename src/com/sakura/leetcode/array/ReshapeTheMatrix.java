package com.sakura.leetcode.array;

/**
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c || (m == r && n == c)) return nums;
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int pos = i * c + j;
                matrix[i][j] = nums[pos / n][pos % n];
            }
        }
        return matrix;
    }
}
