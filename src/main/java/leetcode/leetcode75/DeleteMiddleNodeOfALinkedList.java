package leetcode.leetcode75;

import leetcode.datastructure.ListNode;

/**
 * @author tempo
 */
public class DeleteMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (fast == slow) {
            return null;
        }

        prev.next = slow == null ? null : slow.next;
        return head;
    }
}
