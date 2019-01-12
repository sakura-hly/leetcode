package com.sakura.leetcode.hashtable;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        /************************Monotonous Stack*******************************/
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
//            int count = 1;
//            while (!stack.isEmpty() && stack.peek()[0] <= T[i]) {
//                count += stack.pop()[1];
//            }
//            stack.push(new int[]{T[i], count});
//            result[i] = count;

            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            result[i] = (stack.isEmpty() ? i : stack.peek()) - i;
            stack.push(i);
        }

        return result;
    }


    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
