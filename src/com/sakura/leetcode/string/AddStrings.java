package com.sakura.leetcode.string;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        char[] chs1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] chs2 = new StringBuilder(num2).reverse().toString().toCharArray();
        char[] chs = new char[Math.max(chs1.length, chs2.length) + 1];
        int carry = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            if (i >= chs1.length) {
                chs[i] = (char) ((chs2[i] - '0' + carry) % 10 + '0');
                carry = (chs2[i] - '0' + carry) / 10;
            } else if (i >= chs2.length) {
                chs[i] = (char) ((chs1[i] - '0' + carry) % 10 + '0');
                carry = (chs1[i] - '0' + carry) / 10;
            } else {
                int temp = chs1[i] - '0' + chs2[i] - '0';
                chs[i] = (char) ((temp + carry) % 10 + '0');
                carry = (temp + carry) / 10;
            }
        }

        chs[chs.length - 1] = carry == 0 ? '0' : '1';
        return carry == 0
                ? new StringBuilder(String.valueOf(chs)).reverse().substring(1)
                : new StringBuilder(String.valueOf(chs)).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("123", "56"));
    }
}
