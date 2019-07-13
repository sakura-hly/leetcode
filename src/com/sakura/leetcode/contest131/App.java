package com.sakura.leetcode.contest131;

import java.util.ArrayList;
import java.util.LinkedList;

public class App {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>(num.length - size + 1);
        if (size <= 0) return res;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            int index = i - size + 1;

            if (queue.isEmpty()) {
                queue.add(i);
            } else if (i - size == queue.peekFirst()) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.offer(i);

            if (index >= 0) {
                res.add(num[queue.peek()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.maxInWindows(new int[]{16, 14, 12, 10, 8, 6, 4}, 5));
    }
}
