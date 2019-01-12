package com.sakura.leetcode.hashtable;

import java.util.*;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int size = list.size();
            List<Integer> help = new ArrayList<>(size + 1);
            help.add(0);
            for (int i = 0; i < size; i++) {
                help.add(help.get(help.size() - 1) + list.get(i));
            }

            help.forEach(integer -> {
                if (integer == 0 || integer == help.get(help.size() - 1)) {
                    return;
                }
                if (map.containsKey(integer)) {
                    map.put(integer, map.get(integer) + 1);
                } else {
                    map.put(integer, 1);
                }
            });
        }

        if (map.isEmpty()) {
            return wall.size();
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());
        return wall.size() - list.get(0).getValue();
    }
}
