package com.sakura.leetcode.dynamic;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        Set<Integer> set = new HashSet<>(len);
        for (int a : A) set.add(a);
        int result = 2;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = A[i], b = A[j], count = 2;
                while (set.contains(a + b)) {
                    count++;
                    b = b + a;
                    a = b - a;
                }
                result = Math.max(result, count);
            }
        }
        return result > 2 ? result : 0;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestFibonacciSubsequence().lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
    }
}
