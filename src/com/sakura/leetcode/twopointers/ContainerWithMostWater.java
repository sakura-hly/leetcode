package com.sakura.leetcode.twopointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int result = 0;
        for (int left = 0, right = height.length - 1; left < right; ) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
