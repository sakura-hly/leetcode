package com.sakura.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backTrack(result, temp, candidates, remain - candidates[i], i);// not i + 1 because we can reuse same elements
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
