package com.sakura.leetcode;

import java.util.*;

public class App {

    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        System.out.println(queue);
        int i = 0;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> temp = queue.poll();
            barcodes[i++] = temp.getKey();
            temp.setValue(temp.getValue() - 1);

            if (queue.isEmpty()) break;

            Map.Entry<Integer, Integer> another = queue.poll();
            barcodes[i++] = another.getKey();
            another.setValue(another.getValue() - 1);
            if (temp.getValue() > 0) {
                queue.offer(temp);
            }
            if (another.getValue() > 0) {
                queue.offer(another);
            }
        }
        return barcodes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new App().rearrangeBarcodes(new int[]{7,7,7,8,5,7,5,5,5,8})));
    }
}
