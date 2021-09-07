package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode cursor = head;
        ListNode tail = null;
        while (cursor != null) {
            ListNode temp = cursor.next;
            cursor.next = tail;
            tail = cursor;
            cursor = temp;
        }

        return tail;
    }
}
