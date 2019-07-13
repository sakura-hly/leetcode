package com.sakura.leetcode.contest136;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int res = 0;
        if (K == 1) {
            for (int a : A) {
                res += a;
                return res;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        int start = 0, end = 0;
        while (start < A.length) {
            if (queue.isEmpty() && end < A.length) {
                queue.offer(end);
            } else {
                while (!queue.isEmpty() && end < A.length && A[queue.peekLast()] <= A[end]) {
                    queue.pollLast();
                }
                queue.offer(end);
            }

            if (end - queue.peekFirst() > K - 1) {
                queue.pollFirst();
            }
            if (end < A.length) {
                if (end - start == K - 1) {
                    res += A[queue.peekFirst()];
                    list.add(A[queue.peekFirst()]);
                    start++;
                } else {
                    end++;
                }
            } else {
                res += A[queue.peekFirst()];
                list.add(A[queue.peekFirst()]);
                start++;
            }
        }
        System.out.println(list);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumAfterPartitioning().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}
