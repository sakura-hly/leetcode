package com.sakura.leetcode.graphsearch;

import java.util.*;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> edge = new ArrayList<>(graph.length);
        List<List<Integer>> echo = new ArrayList<>(graph.length);
        for (int i = 0; i < graph.length; i++) echo.add(new ArrayList<>());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = new ArrayList<>(graph[i].length);
            for (int v : graph[i]) {
                list.add(v);
                echo.get(v).add(i);
            }
            if (list.size() == 0) queue.offer(i);
            edge.add(list);
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                Integer v = queue.poll();
                res.add(v);
                for (Integer prev : echo.get(v)) {
                    edge.get(prev).remove(v);
                    if (edge.get(prev).size() == 0) {
                        queue.offer(prev);
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
