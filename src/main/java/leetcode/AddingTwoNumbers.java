package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class AddingTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        boolean carry = false;
        ListNode root = new ListNode(0);
        ListNode tail = root;
        while (cursor1 != null && cursor2 != null) {
            int val = cursor1.val + cursor2.val;
            if (carry) {
                val++;
            }
            tail.next = new ListNode(val % 10);
            tail = tail.next;
            carry = val >= 10;
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }

        ListNode remaining = cursor1 != null ? cursor1 : cursor2;
        while (remaining != null) {
            if (carry) {
                int val = remaining.val + 1;
                tail.next = new ListNode(val % 10);
                tail = tail.next;
                carry = val >= 10;
                remaining = remaining.next;
            } else {
                tail.next = remaining;
                return root.next;
            }
        }

        if (carry) {
            tail.next = new ListNode(1);
        }
        return root.next;
    }
}
