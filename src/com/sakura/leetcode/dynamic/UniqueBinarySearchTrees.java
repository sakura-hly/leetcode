package com.sakura.leetcode.dynamic;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;

        // G(n) = F(1, n) + F(2, n) + ... + F(n, n)
        // F(i, n) = G(i - 1) * G (n - i)

        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
    }
}
