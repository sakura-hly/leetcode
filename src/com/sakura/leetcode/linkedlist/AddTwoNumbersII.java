package com.sakura.leetcode.linkedlist;

import java.util.Stack;

public class AddTwoNumbersII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode result = new ListNode(0);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();

            result.val = sum % 10;
            sum /= 10;
            ListNode head = new ListNode(sum);
            head.next = result;
            result = head;
        }

        return result.val == 0 ? result.next : result;
    }
}
