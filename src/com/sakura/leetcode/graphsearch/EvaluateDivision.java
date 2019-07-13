package com.sakura.leetcode.graphsearch;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            if (!map.containsKey(equation.get(0))) {
                Map<String, Double> temp = new HashMap<>();
                temp.put(equation.get(1), values[i]);
                map.put(equation.get(0), temp);
            } else {
                map.get(equation.get(0)).put(equation.get(1), values[i]);
            }
            if (!map.containsKey(equation.get(1))) {
                Map<String, Double> temp = new HashMap<>();
                temp.put(equation.get(0), 1.0 / values[i]);
                map.put(equation.get(1), temp);
            } else {
                map.get(equation.get(1)).put(equation.get(0), 1.0 / values[i]);
            }
        }

        double[] answer = new double[queries.size()];
        System.out.println(map);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (query.get(0).equals(query.get(1)) && map.containsKey(query.get(0))) {
                answer[i] = 1.0;
            } else if (!map.containsKey(query.get(0))) {
                answer[i] = -1.0;
            } else {
                answer[i] = bfs(map, query);
            }
        }
        return answer;
    }

    private double bfs(Map<String, Map<String, Double>> map, List<String> query) {
        double answer = 1.0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String s1 = query.get(0), s2 = query.get(1);
        visited.add(s1);
        queue.offer(s1);

        map.get(query.get(0)).put(query.get(0), 1.0);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s2.equals(s)) return map.get(s1).get(s2);

            for (String next : map.get(s).keySet()) {
                if (visited.contains(next)) continue;
                visited.add(next);
                map.get(s1).put(next, map.get(s1).get(s) * map.get(s).get(next));
            }

        }
        return -1.0;
    }

}
