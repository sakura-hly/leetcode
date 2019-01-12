package com.sakura.leetcode.hashtable;


import java.util.*;

public class MostFrequentSubtreeSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        recursive(root, map);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        int max = list.get(0).getValue();
        List<Integer> help = new ArrayList<>(list.size());
        list.forEach(entry -> {
            if (entry.getValue() == max) {
                help.add(entry.getKey());
            }
        });

        int[] result = new int[help.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = help.get(i);
        }
        return result;
    }

    private int recursive(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int sum = root.val;
        if (root.left != null) {
            sum += recursive(root.left, map);
        }
        if (root.right != null) {
            sum += recursive(root.right, map);
        }

        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        MostFrequentSubtreeSum m = new MostFrequentSubtreeSum();

        TreeNode root = m.new TreeNode(5);
        root.left = m.new TreeNode(2);
        root.right = m.new TreeNode(-5);

        m.findFrequentTreeSum(root);
    }
}
