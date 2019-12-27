package com.sakura.leetcode.top100like;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String s = queue.poll();
        if ("null".equals(s)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        String s = codec.serialize(root);
        System.out.println(s);
        codec.deserialize(s);
    }
}
