package com.sakura.leetcode.linkedlist;

public class InsertionSortList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;

            while (pre.next != null && pre.next.val < node.val) {
                pre = pre.next;
            }

            node.next = pre.next;
            pre.next = node;

            //node.next.next = next;
            pre = dummy;

            node = next;
        }

        return dummy.next;
    }
}
