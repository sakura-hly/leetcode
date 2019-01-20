package com.sakura.leetcode.string;

import java.util.*;

public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new LinkedList<>();

        int[] help = new int[26];
        for (String b : B) {
            int[] temp = help(b);
            for (int i = 0; i < temp.length; i++) {
                help[i] = Math.max(help[i], temp[i]);
            }
        }

        for (String a : A) {
            int[] temp = help(a);
            result.add(a);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] < help[i]) {
                    result.remove(a);
                    break;
                }
            }
        }

        return result;
    }

    private int[] help(String b) {
        int[] temp = new int[26];
        for (int i = 0; i < b.length(); i++)
            temp[b.charAt(i) - 'a']++;
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new WordSubsets().wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"ec", "oc", "ceo"}));
    }
}
