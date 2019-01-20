package com.sakura.leetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0, mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            result = (result + map.getOrDefault(target - A[i], 0)) % mod;

            for (int j = 0; j < i; j++) {
                int temp = A[j] + A[i];
                map.put(temp, map.getOrDefault(temp,0) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumWithMultiplicity().threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
    }
}
