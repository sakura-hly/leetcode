package com.sakura.leetcode.graphsearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) set.add(deadend);
        Queue<String> queue = new LinkedList<>();
        visited.add("0000");
        queue.offer("0000");

        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            System.out.println(res + " -> " + queue);
            while (count-- > 0) {
                String start = queue.poll();
                if (target.equals(start)) return res;
                if (set.contains(start)) continue;
                if (!"0000".equals(start) && visited.contains(start)) continue;
                visited.add(start);

                char[] slot = start.toCharArray();
                // ++++
                for (int i = 0; i < 4; i++) {
                    if (slot[i] == '9') {
                        slot[i] = '0';
                        String next = new String(slot);
                        if (visited.contains(next)) {
                            slot[i] = '9';
                            continue;
                        }
                        queue.offer(next);
                        slot[i] = '9';
                    } else {
                        slot[i]++;
                        String next = new String(slot);
                        if (visited.contains(next)) {
                            slot[i]--;
                            continue;
                        }
                        queue.offer(next);
                        slot[i]--;
                    }
                }

                // ----
                for (int i = 0; i < 4; i++) {
                    if (slot[i] == '0') {
                        slot[i] = '9';
                        String next = new String(slot);
                        if (visited.contains(next)) {
                            slot[i] = '0';
                            continue;
                        }
                        queue.offer(next);
                        slot[i] = '0';
                    } else {
                        slot[i]--;
                        String next = new String(slot);
                        if (visited.contains(next)) {
                            slot[i]++;
                            continue;
                        }
                        queue.offer(next);
                        slot[i]++;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private int dfs(Set<String> visited, Set<String> deadends, String start, String target) {
        if (deadends.contains(start)) return 10000;
        if (target.equals(start)) return 0;

        int res = 10000;
        char[] slot = start.toCharArray();
        // ++++
        for (int i = 0; i < 4; i++) {
            if (slot[i] == '9') {
                slot[i] = '0';
                String next = new String(slot);
                if (visited.contains(next)) continue;
                visited.add(next);
//                System.out.println(next);
                res = Math.min(res, dfs(visited, deadends, next, target));
                slot[i] = '9';
            } else {
                slot[i]++;
                String next = new String(slot);
                if (visited.contains(next)) continue;
                visited.add(next);
//                System.out.println(next);
                res = Math.min(res, dfs(visited, deadends, next, target));
                slot[i]--;
            }
        }

        // ----
        for (int i = 0; i < 4; i++) {
            if (slot[i] == '0') {
                slot[i] = '9';
                String next = new String(slot);
                if (visited.contains(next)) continue;
                visited.add(next);
//                System.out.println(next);
                res = Math.min(res, dfs(visited, deadends, next, target));
                slot[i] = '0';
            } else {
                slot[i]--;
                String next = new String(slot);
                if (visited.contains(next)) continue;
                visited.add(next);
//                System.out.println(next);
                res = Math.min(res, dfs(visited, deadends, next, target));
                slot[i]++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OpenLock().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0607"));
    }
}
