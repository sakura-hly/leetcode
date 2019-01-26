package com.sakura.leetcode.dynamic;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        boolean[][] dp = new boolean[A.length][A.length];
        int result = 0;

        for (int i = 0; i < A.length - 2; i++) {
            if (IsArithmetic(A[i], A[i + 1], A[i + 2])) {
                dp[i][i + 2] = true;
                result++;
            } else {
                dp[i][i + 2] = false;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 3; j < A.length; j++) {
                if (dp[j - 3][j - 1]) {
                    if (IsArithmetic(A[j - 2], A[j - 1], A[j])) {
                        dp[i][j] = true;
                        dp[j - 2][j] = true;
                        result++;
                    } else {
                        dp[j - 2][j] = false;
                    }
                } else {
                    if (IsArithmetic(A[j - 2], A[j - 1], A[j])) {
                        if (!dp[j - 2][j]) {
                            dp[j - 2][j] = true;
                            result++;
                        }
                    } else {
                        dp[j - 2][j] = false;
                    }
                }
            }
        }
        return result;
    }

    private boolean IsArithmetic(int a, int b, int c) {
        return b << 1 == a + c;
    }

    /*
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0, temp = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] * 2 == A[i] + A[i - 2]) {
                temp++;
                result += temp;
            } else {
                temp = 0;
            }
        }
        return result;
    }
     */
    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }
}
