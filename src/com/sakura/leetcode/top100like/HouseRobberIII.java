package com.sakura.leetcode.top100like;

import java.util.HashMap;

public class HouseRobberIII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob1(TreeNode root) {
        // rob(root) which will return the maximum amount of money that we can rob for the binary tree rooted at root
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int res = 0;
        if (root.left != null) {
            res += rob1(root.left.left) + rob1(root.left.right);
        }
        if (root.right != null) {
            res += rob1(root.right.left) + rob1(root.right.right);
        }

        return Math.max(res + root.val, rob1(root.left) + rob1(root.right));
    }

    public int rob2(TreeNode root) {
        return robSub2(root, new HashMap<>());
    }

    private int robSub2(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int res = 0;
        if (root.left != null) {
            res += robSub2(root.left.left, map) + robSub2(root.left.right, map);
        }
        if (root.right != null) {
            res += robSub2(root.right.left, map) + robSub2(root.right.right, map);
        }

        res = Math.max(res + root.val, robSub2(root.left, map) + robSub2(root.right, map));
        map.put(root, res);
        return res;
    }

    public int rob3(TreeNode root) {
        int[] result = robSub3(root);
        // result[0] -- not robbed
        // result[1] -- robbed
        return Math.max(result[0], result[1]);
    }

    private int[] robSub3(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub3(root.left);
        int[] right = robSub3(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
