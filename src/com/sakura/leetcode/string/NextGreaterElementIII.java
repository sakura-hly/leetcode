package com.sakura.leetcode.string;

import java.util.Arrays;

public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        if (n <= 11) {
            return -1;
        }

        String num = String.valueOf(n);
        int len = num.length();
        for (int i = len - 1; i > 0; i--) {
            if (num.charAt(i) - '0' > num.charAt(i - 1) - '0') {
                int m = i, min_index = i;
                while (m < len && num.charAt(m) - '0' > num.charAt(i - 1) - '0') {
                    min_index = num.charAt(m) - '0' < num.charAt(min_index) - '0' ? m : min_index;
                    m++;
                }
                //if (m == len) m--;
                String str = num.substring(0, i - 1) +
                        num.substring(min_index, min_index + 1) +
                        num.substring(i, min_index) +
                        num.substring(i - 1, i) +
                        num.substring(min_index + 1, len);

                char[] arr = str.toCharArray();
                Arrays.sort(arr, i, len);
                long result = Long.valueOf(new String(arr));
                return result <= Integer.MAX_VALUE ? (int) result : -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElementIII().nextGreaterElement(230241));
    }
}
