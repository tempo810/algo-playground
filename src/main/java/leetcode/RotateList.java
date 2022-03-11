package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int size = 0;
        ListNode cursor = head;
        ListNode tail = null;
        while (cursor != null) {
            tail = cursor;
            cursor = cursor.next;
            size++;
        }

        int numOfRotate = k % size;
        if (numOfRotate == 0) {
            return head;
        }
        int index = 1;
        cursor = head;

        while (index < size - numOfRotate) {
            cursor = cursor.next;
            index++;
        }
        ListNode newHead = cursor.next;
        cursor.next = null;
        tail.next = head;
        return newHead;
    }
}
