package com.sakura.leetcode.array;

import java.util.Arrays;

public class BuildTree2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int rootPos = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[postorder.length - 1] == inorder[i]) {
                rootPos = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootPos),
                Arrays.copyOfRange(postorder, 0, rootPos));
        root.right = buildTree(Arrays.copyOfRange(inorder, rootPos + 1, inorder.length),
                Arrays.copyOfRange(postorder, rootPos, postorder.length - 1));


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
        new BuildTree2().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
