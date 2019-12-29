package com.sakura.leetcode.top100like;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        int result = 0;

        // build left
        for (int i = 1; i < n; i++) {
            int curLft = i - 1;
            while (curLft >= 0 && heights[curLft] >= heights[i]) {
                curLft = left[curLft] - 1;
            }
            left[i] = curLft + 1;
        }

        // build right
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int curRight = i + 1;
            while (curRight < n && heights[curRight] >= heights[i]) {
                curRight = right[curRight] + 1;
            }
            right[i] = curRight - 1;
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, (right[i] - left[i] + 1) * heights[i]);
        }
        return result;
    }

    public int largestRectangleArea2(int[] heights) {
        // https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            max = Math.max(max,
                    heights[stack.pop()] * (stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea2(new int[] { 2, 1, 5, 6, 2, 3 }));
    }
}
