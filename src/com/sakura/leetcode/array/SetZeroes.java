package com.sakura.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> setR = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setR.add(i);
                    setC.add(j);
                }
            }
        }

        for (int r : setR) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }

        for (int c : setC) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new SetZeroes().setZeroes(new int[][]{{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}});
    }
}
