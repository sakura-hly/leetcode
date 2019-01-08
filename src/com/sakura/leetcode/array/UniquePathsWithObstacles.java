package com.sakura.leetcode.array;

public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];

        dp[0] = 1;

        for (int m = 0; m < obstacleGrid.length; m++) {
            for (int n = 0; n < obstacleGrid[0].length; n++) {
                if (obstacleGrid[m][n] == 1) {
                    dp[n] = 0;
                } else if (n > 0) {
                    dp[n] += dp[n - 1];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles()
                .uniquePathsWithObstacles(
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}
                        }));
    }
}
