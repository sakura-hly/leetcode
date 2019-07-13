package com.sakura.leetcode.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {

    private final int MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] A) {
        if (A == null) return 0;
        if (A.length <= 1) return A.length;

        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            long count = 1L;
            for (Integer key : map.keySet()) {
                if (A[i] % key == 0) {
                    count = (count + (map.get(key) * map.getOrDefault(A[i] / key, 0l) % MOD)) % MOD;
                }
            }
            map.put(A[i], count);
        }

        // System.out.println(map);
        long res = 0;
        for (long value : map.values()) {
            res = (res + value % MOD) % MOD;
        }
        return (int) res;
    }

    public static void main(String[] args) {

    }
}
