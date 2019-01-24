package com.sakura.leetcode.binarysearch;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int count = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        queue.offer(new int[]{0, 0});

        while (true) {
            int[] temp = queue.poll();
            if (++count == k) {
                return matrix[temp[0]][temp[1]];
            }

            if (temp[0] == 0 && temp[1] + 1 < matrix[0].length) {
                queue.offer(new int[]{temp[0], temp[1] + 1});
            }

            if (temp[0] + 1 < matrix.length) {
                queue.offer(new int[]{temp[0] + 1, temp[1]});
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInSortedMatrix()
                .kthSmallest(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 8));
    }
}
