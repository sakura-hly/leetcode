package com.sakura.leetcode.array;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0, r = m * n - 1;
        while (l != r) {
            int middle = (l + r) >> 1;

            if (matrix[middle / m][middle % m] < target) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return matrix[r / m][r % m] == target;
    }

    public static void main(String[] args) {
        System.out.println(new SearchMatrix()
                .searchMatrix(
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 50}
                        }, 13));
    }
}
