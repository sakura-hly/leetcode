package com.sakura.leetcode.tree;

public class RangeSumQuery {
    private SegmentTreeNode root;

    public RangeSumQuery(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        SegmentTreeNode node = new SegmentTreeNode(l, r);
        if (l == r) {
            node.sum = nums[l];
        } else {
            int mid = (r - l) / 2 + l;
            node.left = buildTree(nums, l, mid);
            node.right = buildTree(nums, mid + 1, r);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val) {
        if (root.l == root.r) {
            root.sum = val;
        } else {
            int mid = (root.r - root.l) / 2 + root.l;
            if (mid >= i) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.l == i && root.r == j) {
            return root.sum;
        } else {
            int mid = (root.r - root.l) / 2 + root.l;
            if (mid + 1 <= i) {
                return sumRange(root.right, i, j);
            } else if (mid >= j) {
                return sumRange(root.left, i, j);
            } else {
                return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
            }
        }
    }

    class SegmentTreeNode {
        int sum, l, r;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        RangeSumQuery rangeSumQuery = new RangeSumQuery(new int[]{0, 9, 5, 7, 3});
        System.out.println(rangeSumQuery.sumRange(4, 4));
        System.out.println(rangeSumQuery.sumRange(2, 4));
        System.out.println(rangeSumQuery.sumRange(3, 3));
        rangeSumQuery.update(4, 5);
        rangeSumQuery.update(1, 7);
        rangeSumQuery.update(0, 8);
        System.out.println(rangeSumQuery.sumRange(1, 2));
        rangeSumQuery.update(1, 9);
        System.out.println(rangeSumQuery.sumRange(4, 4));
        rangeSumQuery.update(3, 4);
    }
}
