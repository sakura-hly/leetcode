package com.sakura.leetcode.array;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();

        if (nums.length == 1){
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int index = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (i - index == 1) {
                    result.add(String.valueOf(nums[index]));
                } else {
                    result.add(nums[index] + "->" + nums[i - 1]);
                }

                index = i;
            }

            if (i == nums.length - 1) {
                if (i == index) {
                    result.add(String.valueOf(nums[index]));
                } else {
                    result.add(nums[index] + "->" + nums[i]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-1}));
    }
}
