package com.sakura.leetcode.top100like;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int levelNum = queue.size();

            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left!=null) queue.offer(queue.peek().left);
                if (queue.peek().right!=null) queue.offer(queue.peek().right);

                temp.add(queue.poll().val);
            }

            result.add(temp);
        }

        return result;
    }
}
