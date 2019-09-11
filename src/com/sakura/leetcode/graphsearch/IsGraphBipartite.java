package com.sakura.leetcode.graphsearch;

import java.util.Arrays;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] v = new int[graph.length];
        for (int i = 0; i < v.length; i++) v[i] = i;

        for (int i = 0; i < graph.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < graph[i].length; j++) {
                if (find(v, i) == find(v, graph[i][j])) return false;
                min = Math.min(min, graph[i][j]);
            }
            for (int j = 0; j < graph[i].length; j++) {
                v[graph[i][j]] = min;
            }
        }
        return true;
    }

    private int find(int[] v, int i) {
        if (v[i] != i) {
            v[i] = find(v, v[i]);
        }
        return v[i];
    }

    public static void main(String[] args) {
        System.out.println(new IsGraphBipartite()
                .isBipartite(new int[][]{
                        {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
                }));
    }
}
