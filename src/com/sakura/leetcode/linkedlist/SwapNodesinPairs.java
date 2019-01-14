package com.sakura.leetcode.linkedlist;

public class SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head, dummy = new ListNode(-1), last = dummy;
        while (node != null && node.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = node;

            last.next = next;
            last = node;

            node = node.next;
        }
        return dummy.next != null ? dummy.next : head;
    }
}
