package com.github.lkq;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 *  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(make(4, 3, 5), make(2, 7, 3));
        while (result != null) {
            System.out.print(" -> "+ result.val);
            result = result.next;
        }
    }

    private static ListNode make(int... values) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return head.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode resultHead = new ListNode(0);
            ListNode currentHead = resultHead;

            int adder = 0;
            int carry = 0;

            while (l1 != null || l2 != null) {
                adder = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
                carry = adder >= 10 ? 1 : 0;
                adder %= 10;

                currentHead.next = new ListNode(adder);
                currentHead = currentHead.next;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            if (carry > 0) {
                currentHead.next = new ListNode(carry);
            }
            return resultHead.next;
        }
    }
}