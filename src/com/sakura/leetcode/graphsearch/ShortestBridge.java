package com.sakura.leetcode.graphsearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    public int shortestBridge(int[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (!queue.isEmpty()) break;
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    add(queue, i, j, A, visited);
                    break;
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            for (int[] p : queue) System.out.print(Arrays.toString(p));
            System.out.println();
            int count = queue.size();
            while (count-- > 0) {
                int[] p = queue.poll();
                int i = p[0], j = p[1];
                if (visited[i][j]) continue;
                if (A[i][j] == 1) return res - 1;
                visited[i][j] = true;
                A[i][j] = 1;
                if (i - 1 >= 0 && !visited[i - 1][j])
                    queue.offer(new int[]{i - 1, j});
                if (i + 1 < A.length && !visited[i + 1][j])
                    queue.offer(new int[]{i + 1, j});
                if (j - 1 >= 0 && !visited[i][j - 1])
                    queue.offer(new int[]{i, j - 1});
                if (j + 1 < A[0].length && !visited[i][j + 1])
                    queue.offer(new int[]{i, j + 1});
            }
            res++;
        }
        return -1;
    }

    private void add(Queue<int[]> queue, int i, int j, int[][] A, boolean[][] visited) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length
                || A[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        if ((i - 1 >= 0 && A[i - 1][j] == 0) || (i + 1 < A.length && A[i + 1][j] == 0) ||
                (j - 1 >= 0 && A[i][j - 1] == 0) || (j + 1 < A[0].length && A[i][j + 1] == 0)) {
            A[i][j] = 0;
            visited[i][j] = false;
            queue.offer(new int[]{i, j});
        }
        add(queue, i - 1, j, A, visited);
        add(queue, i + 1, j, A, visited);
        add(queue, i, j - 1, A, visited);
        add(queue, i, j + 1, A, visited);
    }

    public static void main(String[] args) {
        System.out.println(new ShortestBridge()
                .shortestBridge(new int[][]{
                        {1, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}
                }));
    }
}
