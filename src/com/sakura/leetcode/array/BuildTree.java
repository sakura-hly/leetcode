package com.sakura.leetcode.array;

import java.util.Arrays;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootPos = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                rootPos = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootPos),
                Arrays.copyOfRange(inorder, 0, rootPos));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootPos, preorder.length),
                Arrays.copyOfRange(inorder, rootPos + 1, inorder.length));


        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new BuildTree().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
