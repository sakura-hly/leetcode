package com.sakura.leetcode.top100like;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int k1 = (n1 + n2 + 1) / 2, k2 = (n1 + n2 + 2) / 2;;
        return (getkth(nums1, 0, nums2, 0, k1) + getkth(nums1, 0, nums2, 0, k2)) / 2;
    }

    private double getkth(int[] num1, int start1, int[] num2, int start2, int k) {
        if (start1 >= num1.length) return num2[start2 + k - 1];
        if (start2 >= num2.length) return num1[start1 + k - 1];

        if (k == 1) return Math.min(num1[start1], num2[start2]);

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < num1.length) mid1 = num1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < num2.length) mid2 = num2[start2 + k / 2 - 1];

        if (mid1 < mid2) {
            return getkth(num1, start1 + k / 2, num2,        start2,         k - k / 2);
        } else {
            return getkth(num1,        start1,         num2, start2 + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
