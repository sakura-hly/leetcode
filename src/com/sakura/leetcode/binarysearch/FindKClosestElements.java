package com.sakura.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int count = 0, start = 0, last = arr.length - 1;
        while (count++ < arr.length- k) {
            if (x - arr[start] <= arr[last] - x) {
                last--;
            } else {
                start++;
            }
        }

        List<Integer> res = new ArrayList();

        for (int i=start;i<=last;i++){
            res.add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindKClosestElements().findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4));
    }
}
