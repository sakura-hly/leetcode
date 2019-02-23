package com.sakura.leetcode.top100like;

public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int n = lists.length;

        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[n - i - 1]);
            }
            n = k;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode(-1);
            if (l2.val >= l1.val) {
                temp.val = l1.val;
                l1 = l1.next;
            } else {
                temp.val = l2.val;
                l2 = l2.next;
            }
            node.next = temp;
            node = node.next;
        }

        if (l1 != null) node.next = l1;
        if (l2 != null) node.next = l2;
        return dummy.next;
    }
}
