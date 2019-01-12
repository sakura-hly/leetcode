package com.sakura.leetcode.hashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
        }
        return result;
    }

}
