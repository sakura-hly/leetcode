package com.sakura.leetcode.linkedlist;

public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * f = l + r * n
     * s = l + r * (n - 1)
     * <p>
     * l + r * n = 2(l + r * (n - 1))
     * l + r * n = 2 * l + 2 * r * n - 2 * r
     * 2r = l + r * n
     * l = r * (2 - n)
     * <p>
     * s = r * (2 - n) + r * (n - 1) = r
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) {
            // no cycle
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode connect = head;
        while (connect != slow) {
            connect = connect.next;
            slow = slow.next;
        }

        return connect;
    }
}
