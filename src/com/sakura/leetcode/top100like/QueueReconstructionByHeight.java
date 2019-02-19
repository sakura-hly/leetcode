package com.sakura.leetcode.top100like;

import java.util.Arrays;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int pos = people[i][1];
            for (int j = i; j > pos; j--) {
                result[j] = result[j - 1];
            }
            result[pos] = people[i];
        }

        return result;
    }

    public static void main(String[] args) {
        new QueueReconstructionByHeight().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }
}
