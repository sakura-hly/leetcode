package com.sakura.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits.isEmpty()) return result;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backTrack(result, new StringBuilder(), mapping, digits, 0);
        return result;
    }

    private void backTrack(LinkedList<String> result, StringBuilder s, String[] mapping, String digits, int start) {
        if (s.length() == digits.length()) {
            result.add(new String(s));
        } else {
            String temp = mapping[digits.charAt(start) - '0'];
            for (int i = 0; i < temp.length(); i++) {
                s.append(temp.charAt(i));
                backTrack(result, s, mapping, digits, start + 1);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }
}
