package com.sakura.leetcode.array;

public class MaximumSwap {

    public int maximumSwap(int num) {
        if (num <= 11) {
            return num;
        }

        char[] arr = (num + "").toCharArray();

        int firstGreat = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                firstGreat = i;
                break;
            }
        }

        if (firstGreat == -1) {
            return num;
        }

        int position = -1;
        char max = 0;
        for (int i = firstGreat + 1; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                position = i;
            }
        }

        for (int i = 0; i <= firstGreat; i++) {
            if (arr[i] < max) {
                char temp = arr[position];
                arr[position] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(1993));
    }
}
