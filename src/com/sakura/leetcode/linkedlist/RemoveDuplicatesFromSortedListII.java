package com.sakura.leetcode.linkedlist;

public class RemoveDuplicatesFromSortedListII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        boolean flag = false;
        while (cur != null) {
            if (cur.next != null) {
                if (cur.val == cur.next.val) {
                    flag = true;
                } else if (flag) {
                    flag = false;
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            } else {
                if (flag) {
                    pre.next = null;
                }
                return dummy.next;
            }

        }
        return dummy.next;
    }
}
