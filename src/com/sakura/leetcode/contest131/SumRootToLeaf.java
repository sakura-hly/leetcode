package com.sakura.leetcode.contest131;

public class SumRootToLeaf {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;

        int left = sumRootToLeaf(root.left);
        int right = sumRootToLeaf(root.right);

        int result = 0;
        if (root.val == 0) {
            result = left + right;
        } else if (root.val == 1) {
            if (root.left == null) {
                result = getUpper(right) + right;
            } else if (root.right == null) {
                result = getUpper(left) + left;
            } else if (root.left == null && root.right == null) {
                result = 1;
            } else {
                result = getUpper(left) + left + getUpper(right) + right;
            }
        }
        return result;
    }

    private int getUpper(int num) {
        return (int) Math.pow(2, (int) (Math.log(num)/ Math.log(2)) + 1);
    }

    public static void main(String[] args) {
        System.out.println(new SumRootToLeaf().getUpper(9));
    }
}
