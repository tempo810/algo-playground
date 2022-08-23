package leetcode;

import leetcode.datastructure.ListNode;

import java.util.Stack;

/**
 * @author tempo
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stacks = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stacks.add(current);
            current = current.next;
        }

        current = head;

        while (!stacks.isEmpty()) {
            if (stacks.pop().val != current.val) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        current = head;

        while (prev != null) {
            if (current.val != prev.val) {
                return false;
            }
            current = current.next;
            prev = prev.next;
        }
        return true;
    }
}
