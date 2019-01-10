package com.sakura.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>(0);
        }
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

        int beginRow = 0, endRow = matrix.length - 1, beginCol = 0, endCol = matrix[0].length - 1;
        while (beginRow <= endRow && beginCol <= endCol) {
            for (int j = beginCol; j <= endCol; j++) {
                result.add(matrix[beginRow][j]);
            }
            beginRow++;
            for (int i = beginRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;
            if (beginRow <= endRow) {
                for (int j = endCol; j >= beginCol; j--) {
                    result.add(matrix[endRow][j]);
                }
                endRow--;
            }
            if (beginCol <= endCol) {
                for (int i = endRow; i >= beginRow; i--) {
                    result.add(matrix[i][beginCol]);
                }
                beginCol++;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new SpiralMatrix().spiralOrder(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        }));
    }
}
