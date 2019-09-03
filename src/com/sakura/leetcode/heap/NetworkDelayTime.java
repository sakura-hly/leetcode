package com.sakura.leetcode.heap;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] edge1, int[] edge2) -> edge1[2] - edge2[2]);
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.get(edge[0]).put(edge[1], edge[2]);
            if (edge[0] == K) queue.offer(edge);
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            if (visited[edge[1]]) continue;
            visited[edge[1]] = true;
            res = edge[2];
            if (graph.containsKey(edge[1])) {
                for (Map.Entry<Integer, Integer> entry : graph.get(edge[1]).entrySet()) {
                    queue.offer(new int[]{edge[1], entry.getKey(), entry.getValue() + edge[2]});
                }
            }
//            int count = queue.size();
//            int curr = queue.peek()[2];
//            res += curr;
//            List<int[]> list = new LinkedList<>();
//            while (count-- > 0) {
//                int[] edge = queue.poll();
//                if (visited[edge[1]]) continue;
//                if (edge[2] == curr) {
//                    if (graph.containsKey(edge[1])) {
//                        for (Map.Entry<Integer, Integer> entry : graph.get(edge[1]).entrySet()) {
//                            if (!visited[entry.getKey()]) {
//                                list.add(new int[]{edge[1], entry.getKey(), entry.getValue()});
//                            }
//                        }
//                    }
//                    visited[edge[1]] = true;
//                } else {
//                    edge[2] -= curr;
//                    list.add(edge);
//                }
//            }
//            for (int[] edge : list) queue.offer(edge);
//            list.clear();
        }

        for (int i = 1; i <= N; i++) if (!visited[i]) return -1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new NetworkDelayTime()
                        .networkDelayTime(
                                new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}},
                                3, 1));
    }
}
