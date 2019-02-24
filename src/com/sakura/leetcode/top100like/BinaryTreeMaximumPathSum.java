package com.sakura.leetcode.top100like;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {

    private int maxPathSum = Integer.MIN_VALUE;
    private Map<TreeNode, Integer> map = new HashMap<>();
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        recurse(root);
        return maxPathSum;
    }

    private int recurse(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int left = Math.max(recurse(root.left), 0);
        int right = Math.max(recurse(root.right), 0);
        // int sum = root.val + left + right;
        maxPathSum = Math.max(maxPathSum, root.val + left + right);
        int res = root.val + Math.max(left, right);
        map.put(root, res);
        return res;
    }
}
