package com.sakura.leetcode.binarysearch;

public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length, mid = 0;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }

}
