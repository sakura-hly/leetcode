package com.sakura.leetcode.binarysearch;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

    private int[] persons;
    private int[] times;
    private int[] leadings;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;

        leadings = new int[times.length];
        Map<Integer, Integer> map = new HashMap<>();
        int maxVote = 0;
        for (int i = 0; i < persons.length; i++) {
            int currVote = map.getOrDefault(persons[i], 0) + 1;
            if (currVote >= maxVote) {
                maxVote = currVote;
                leadings[i] = persons[i];
            } else {
                leadings[i] = leadings[i - 1];
            }
            map.put(persons[i], currVote);
        }
    }

    public int q(int t) {
        int left = 0, right = persons.length;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (times[mid] == t) {
                left = mid + 1;
                break;
            } else if (times[mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == 0 ? leadings[0] : leadings[left - 1];
    }

}
