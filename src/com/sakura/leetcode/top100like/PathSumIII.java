package com.sakura.leetcode.top100like;

import java.util.*;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, sum, 0, map);
    }

    private int helper(TreeNode root, int target, int curr, Map<Integer, Integer> map) {
        if (root == null)
            return 0;
        curr += root.val;
        int res = map.getOrDefault(curr - target, 0);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        res += helper(root.left, target, curr, map) + helper(root.right, target, curr, map);
        map.put(curr, map.get(curr) - 1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        System.out.println(new PathSumIII().pathSum(root, 22));
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}