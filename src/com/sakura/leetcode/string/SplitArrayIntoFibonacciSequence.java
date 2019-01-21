package com.sakura.leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String S) {
        List<List<Integer>> result = new LinkedList<>();
        if (S == null || S.length() < 3) return new ArrayList<>();
        backTrack(result, new ArrayList<>(), S, 0);

        if (result.isEmpty()) {
            return new ArrayList<>();
        }
        return result.get(0);
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, String s, int start) {
        int size = temp.size();
        if (size >= 3 && temp.get(size - 1) != temp.get(size - 2) + temp.get(size - 3)) {
            return;
        }
        if (size >= 3 && start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (i - start > 1 && s.charAt(start) == '0') {
                continue;
            }
            // overflow of int
            long num = Long.valueOf(s.substring(start, i));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            temp.add((int)num);
            backTrack(result, temp, s, i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayIntoFibonacciSequence().splitIntoFibonacci("5511816597"));
    }
}
