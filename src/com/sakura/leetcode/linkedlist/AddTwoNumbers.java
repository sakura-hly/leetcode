package com.sakura.leetcode.linkedlist;

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1=l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2=l2.next;
            }

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (sum / 10 != 0) {
            cur.next = new ListNode(sum / 10);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(10 / 10);
    }
}
