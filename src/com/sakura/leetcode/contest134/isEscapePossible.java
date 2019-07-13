package com.sakura.leetcode.contest134;

import java.util.BitSet;

public class isEscapePossible {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int x = 1000000, y = 1000000;
//        byte[][] flag = new byte[x][y];
        BitSet flag = new BitSet(x * y);
        return dfs(blocked, x, y, flag, source, target);
    }

    private boolean dfs(int[][] blocked, int x, int y, BitSet flag, int[] source, int[] target) {
        int i = source[0], j = source[1];
        if (i < 0 && i >= x && j < 0 && j >= y && flag.get(i * x + j) && blocked[i][j] == 1) {
            return false;
        }
        if (i == target[0] && j == target[1]) {
            return true;
        }
        flag.set(i * x + j);
        if (dfs(blocked, x, y, flag, new int[]{i - 1, y}, target)
                || dfs(blocked, x, y, flag, new int[]{i + 1, y}, target)
                || dfs(blocked, x, y, flag, new int[]{i, y - 1}, target)
                || dfs(blocked, x, y, flag, new int[]{i, y + 1}, target)) {
            return true;
        }
        flag.clear(i * x + j);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new isEscapePossible().isEscapePossible(new int[][]{}, new int[]{0, 0}, new int[]{999999, 999999}));
    }
}
