package com.sakura.leetcode.top100like;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] c = new int[26];
        for (char task : tasks) {
            c[task - 'A']++;
        }
        Arrays.sort(c);

        int i = 25;
        while (c[i] == c[25]) {
            i--;
        }

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
