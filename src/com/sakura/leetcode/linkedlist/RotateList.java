package com.sakura.leetcode.linkedlist;

public class RotateList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k = k % n;

        if (k == 0) {
            return head;
        }

        int step = n - k;
        ListNode cur = head, pre = null;
        while (step-- > 0) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = null;
        tail.next = head;
        return cur;
    }
}
