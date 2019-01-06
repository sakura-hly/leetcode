package com.sakura.leetcode.array;

import java.util.*;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        List<Interval> result = new LinkedList<>();

        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        MergeIntervals mergeIntervals = new MergeIntervals();
        intervals.add(mergeIntervals.new Interval(1, 4));
        intervals.add(mergeIntervals.new Interval(2, 3));
//        intervals.add(mergeIntervals.new Interval(8, 10));
//        intervals.add(mergeIntervals.new Interval(15, 18));

        System.out.println(mergeIntervals.merge(intervals));
    }
}
