package com.sakura.leetcode.hashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, (o1, o2) -> o2.length() - o1.length());
        String[] arr = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            for (String s : dict) {
                if (arr[i].startsWith(s)) {
                    temp = s;
                }
            }
            sb.append(temp);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceWords().replaceWords(Arrays.asList(new String[]{"cat", "bat", "rat"}), "the cattle was rattled by the battery"));
    }
}
