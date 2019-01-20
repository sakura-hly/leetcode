package com.sakura.leetcode.twopointers;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int[] help = new int[256];

        for (char c : c1) {
            help[c]++;
        }

        int len1 = c1.length;
        // slide window
        for (int i = 0, j = 0; j < c2.length; j++) {
            if (help[c2[j]]-- > 0) {
                len1--;
            }

            while (len1 == 0) {
                if (j - i + 1 == c1.length) return true;

                if (++help[c2[i++]] > 0) len1++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
    }
}
