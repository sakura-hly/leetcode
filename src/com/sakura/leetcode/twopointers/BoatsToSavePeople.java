package com.sakura.leetcode.twopointers;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int result = 0;
        for (int left = 0, right = people.length - 1; left <= right; ) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }
}
