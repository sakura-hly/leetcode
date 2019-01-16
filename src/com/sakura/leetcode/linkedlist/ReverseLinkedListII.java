package com.sakura.leetcode.linkedlist;

public class ReverseLinkedListII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preM = dummy, nodeM = dummy;

        while (m-- > 0) {
            n--;
            preM = nodeM;
            nodeM = nodeM.next;
        }
        ListNode pre = preM, cur = nodeM;
        n++;
        while (n-- > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        preM.next = pre;
        nodeM.next = cur;

        return dummy.next;
    }
}
