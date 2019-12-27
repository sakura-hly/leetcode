package com.sakura.leetcode.top100like;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

    /*********************************  BFS *******************************************/
    public List<String> removeInvalidParenthesesBfs(String s) {
        List<String> list = new LinkedList<>();

        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        set.add(s);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (validParentheses(str)) {
                list.add(str);
                continue;
            }
            if (list.size() > 0) continue; // bfs, so next round can't be the minimum

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                String next = str.substring(0, i) + str.substring(i + 1);
                if (!set.contains(next)) {
                    queue.offer(next);
                    set.add(next);
                }
            }
        }

        return list;
    }

    private boolean validParentheses(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0;
    }


    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
    }
}
