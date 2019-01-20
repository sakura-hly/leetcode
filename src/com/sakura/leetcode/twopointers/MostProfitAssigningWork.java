package com.sakura.leetcode.twopointers;

import java.util.*;

public class MostProfitAssigningWork {
    class Pair {
        public Pair(int diff, int prof) {
            this.diff = diff;
            this.prof = prof;
        }

        int diff;
        int prof;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair> jobs = new ArrayList<>();

        int len = profit.length;
        for (int i = 0; i < len; i++) {
            jobs.add(new Pair(difficulty[i], profit[i]));
        }

        int result = 0, i = 0, maxp = 0;
        Collections.sort(jobs, (o1, o2) -> o1.diff - o2.diff);
        Arrays.sort(worker);

        for (int ability : worker) {
            while (i < len && ability >= jobs.get(i).diff) {
                maxp = Math.max(maxp, jobs.get(i++).prof);
            }
            result += maxp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MostProfitAssigningWork().maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}));
    }
}
