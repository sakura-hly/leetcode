package com.sakura.leetcode.binarysearch;

public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;

        // search start at top right corner or left below corner
        int row = m - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Search2DMatrixII()
//                .searchMatrix(new int[][]{
//                        {1, 4, 7, 11, 15},
//                        {2, 5, 8, 12, 19},
//                        {3, 6, 9, 16, 22},
//                        {10, 13, 14, 17, 24},
//                        {18, 21, 23, 26, 30}}, 5));
        System.out.println(new Search2DMatrixII()
                .searchMatrix(new int[][]{{1, 1}}, 2));
    }
}
