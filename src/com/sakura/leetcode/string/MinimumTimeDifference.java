package com.sakura.leetcode.string;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        int[] help = new int[timePoints.size()];
        for (int i = 0; i < help.length; i++) {
            String[] temp = timePoints.get(i).split(":");
            help[i] = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        }

        Arrays.sort(help);

        int result = help[0] + 24 * 60 - help[help.length - 1];

        for (int i = 1; i < help.length; i++) {
            result = Math.min(result, help[i] - help[i - 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumTimeDifference().findMinDifference(Arrays.asList("23:59", "00:00")));
    }
}
