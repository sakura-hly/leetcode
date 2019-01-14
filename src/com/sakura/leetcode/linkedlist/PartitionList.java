package com.sakura.leetcode.linkedlist;

public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode precur = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                precur.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                prev = prev.next;
            }
            precur = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        PartitionList p = new PartitionList();
        ListNode l1 = p.new ListNode(2);
        ListNode l2 = p.new ListNode(1);
//        ListNode l3 = p.new ListNode(3);
//        ListNode l4 = p.new ListNode(2);
//        ListNode l5 = p.new ListNode(5);
//        ListNode l6 = p.new ListNode(2);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
        p.partition(l1, 2);
    }
}
