package com.sakura.leetcode.top100like;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    private List<String> result = new ArrayList<>();
    private Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        removeRight(s);
        return result;
    }

    private void removeRight(String s) {
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') match++;
            if (s.charAt(i) == ')') match--;

            if (match < 0) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(j) != ')') continue;
                    String temp = s.substring(0, j) + s.substring(j + 1);
                    if (set.contains(temp)) continue;
                    set.add(temp);
                    removeRight(temp);
                }
                return;
            }
        }

        if (match == 0) {
            result.add(s);
            return;
        }
        removeLeft(s);
    }

    private void removeLeft(String s) {
        int match = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') match++;
            if (s.charAt(i) == '(') match--;

            if (match < 0) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) != '(') continue;
                    String temp = s.substring(0, j) + s.substring(j + 1);
                    if (set.contains(temp)) continue;
                    set.add(temp);
                    removeLeft(temp);
                }
                return;
            }
        }

        if (match == 0) {
            result.add(s);
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
    }
}
