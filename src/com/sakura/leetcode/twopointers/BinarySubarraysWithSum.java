package com.sakura.leetcode.twopointers;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        int sum = 0, result = 0;
        int[] count = new int[A.length + 1];
        count[0] = 1;

        for (int i : A) {
            sum += i;
            if (sum >= S) {
                result += count[sum - S];
            }
            count[sum]++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
