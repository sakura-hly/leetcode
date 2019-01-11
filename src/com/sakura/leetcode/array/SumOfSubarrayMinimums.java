package com.sakura.leetcode.array;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] A) {
        int res = 0, mod = (int) 1e9 + 7;
        int[] left = new int[A.length], right = new int[A.length];
        Stack<int[]> stack1 = new Stack<>(), stack2 = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack1.isEmpty() && stack1.peek()[0] > A[i]) {
                count += stack1.pop()[1];
            }
            stack1.push(new int[]{A[i], count});
            left[i] = count;
        }

        for (int i = A.length - 1; i >= 0; i--) {
            int count = 1;
            while (!stack2.isEmpty() && stack2.peek()[0] >= A[i]) {
                count += stack2.pop()[1];
            }
            stack2.push(new int[]{A[i], count});
            right[i] = count;
        }

        for (int i = 0; i < A.length; i++) {
            res = (res + A[i] * left[i] * right[i]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
