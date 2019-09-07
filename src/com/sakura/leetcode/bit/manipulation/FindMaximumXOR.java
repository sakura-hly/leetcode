package com.sakura.leetcode.bit.manipulation;

public class FindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int max = Integer.MIN_VALUE, res = 0;
        for (int num : nums) max = Math.max(max, num);
        int highestBit = 1 << 30;
        while (highestBit > 0) {
            if ((highestBit & max) != 0) break;
            highestBit = highestBit >>> 1;
        }
        System.out.println(highestBit);
        TrieTreeNode root = new TrieTreeNode();
        root.children = new TrieTreeNode[2];
        for (int num : nums) {
            addNumToTrieTree(root, num, highestBit);
        }

        // compute
        res = compute(root.children[0], root.children[1]);

        return res;
    }

    private int compute(TrieTreeNode child0, TrieTreeNode child1) {
        if (child1 == null) return compute(child0.children[0], child0.children[1]);
        if (child0 == null) return compute(child1.children[0], child1.children[1]);
        if (child0.isEnd || child1.isEnd) return child0.val ^ child1.val;
        if (child0.children[0] == null)
            return compute(child0.children[1], child1.children[0] != null ? child1.children[0] : child1.children[1]);
        else if (child0.children[1] == null)
            return compute(child0.children[0], child1.children[1] != null ? child1.children[1] : child1.children[0]);
        else if (child1.children[0] == null)
            return compute(child1.children[1], child0.children[0]);
        else if (child1.children[1] == null)
            return compute(child1.children[0], child0.children[1]);
        else
            return Math.max(compute(child0.children[0], child1.children[1]),
                    compute(child0.children[1], child1.children[0]));
    }

    private void addNumToTrieTree(TrieTreeNode root, int num, int highestBit) {
        while (highestBit > 0) {
            if ((num & highestBit) == 0) {
                if (root.children[0] == null) {
                    TrieTreeNode child0 = new TrieTreeNode();
                    child0.children = new TrieTreeNode[2];
                    root.children[0] = child0;
                }
                root = root.children[0];
            } else {
                if (root.children[1] == null) {
                    TrieTreeNode child1 = new TrieTreeNode();
                    child1.children = new TrieTreeNode[2];
                    root.children[1] = child1;
                }
                root = root.children[1];
            }
            highestBit = highestBit >>> 1;
        }
        root.isEnd = true;
        root.val = num;
    }

    class TrieTreeNode {
        int val;
        boolean isEnd;
        TrieTreeNode[] children;
    }

    public static void main(String[] args) {
        System.out.println(new FindMaximumXOR().findMaximumXOR(new int[]{4, 6, 7}));
    }
}
