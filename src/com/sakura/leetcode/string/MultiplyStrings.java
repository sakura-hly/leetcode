package com.sakura.leetcode.string;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] nums = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j, p2 = i + j + 1;
                int sum = temp + nums[p2];

                nums[p2] = sum % 10;
                nums[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }

}
