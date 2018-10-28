package com.sakura.array;


public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return null;
        }
        int[][] result = new int[n][n];
        int count = 1;
        int i = 0, j = 0;
        //right, down, left, up
        int[] ii = new int[]{0, 1, 0, -1}, jj = new int[]{1, 0, -1, 0};
        int direction = 0;
        while (count <= n * n) {
            if (i >= 0 && i < n && j >= 0 && j < n) {
                result[i][j] = count++;
                int tempi = i + ii[direction], tempj = j + jj[direction];
                if (tempi < 0 || tempi >= n || tempj < 0 || tempj >= n || result[tempi][tempj] != 0) {
                    direction++;
                    direction = direction == 4 ? 0 : direction;
                }
                i += ii[direction];
                j += jj[direction];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrixII().generateMatrix(3));
    }
}
