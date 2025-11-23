package leetcode.leetcode75;

import leetcode.datastructure.ListNode;

/**
 * @author tempo
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddIndexTail = head;
        ListNode evenIndexHead = head.next;
        ListNode evenIndexTail = head.next;
        while (evenIndexTail != null && evenIndexTail.next != null) {
            oddIndexTail.next = evenIndexTail.next;
            oddIndexTail = oddIndexTail.next;
            evenIndexTail.next = evenIndexTail.next.next;
            evenIndexTail = evenIndexTail.next;
        }
        oddIndexTail.next = evenIndexHead;
        return head;
    }
}
