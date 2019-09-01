package com.sakura.leetcode.dynamic;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        sum /= k;

        boolean[] visited = new boolean[nums.length];

        return backtrack(visited, nums, k, sum, 0, 0);
    }

    private boolean backtrack(boolean[] visited, int[] nums, int k,
                              int target, int sum, int start) {
        if (k == 0) {
            return true;
        } else if (target == sum) {
            return backtrack(visited, nums, k - 1, target, 0, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && nums[i] + sum <= target) {
                visited[i] = true;
                if (backtrack(visited, nums, k, target, sum + nums[i], i + 1)) return true;
                visited[i] = false;

            }
        }
        return false;
    }
}
