package com.sakura.leetcode.top100like;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
    PriorityQueue<Integer> right = new PriorityQueue<>((i1, i2) -> i1.compareTo(i2));

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (left.isEmpty() && right.isEmpty()) {
            left.offer(num);
        } else if (!right.isEmpty()) {
            if (num > right.peek()) {
                right.offer(num);
            } else {
                left.offer(num);
            }
        } else {
            if (num < left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }
        }

        while (right.size() - left.size() > 1) left.offer(right.poll());
        while (left.size() - right.size() > 1) right.offer(left.poll());
    }

    public double findMedian() {
        if (left.isEmpty() && right.isEmpty()) return 0.0;
        if (left.size() == right.size()) return (right.peek() + left.peek()) / 2.0;
        return left.size() > right.size() ? left.peek() : right.peek();
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());
    }
}
