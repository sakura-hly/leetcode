package com.sakura.leetcode.dynamic;

public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int result = 10;
        int uniqueDigits = 9, availableNumbers = 9;
        while (n-- > 1 && availableNumbers > 0) {
            uniqueDigits = uniqueDigits * availableNumbers;
            result += uniqueDigits;
            availableNumbers--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
    }
}
