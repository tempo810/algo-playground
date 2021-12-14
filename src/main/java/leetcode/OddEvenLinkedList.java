package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode mergeHead = null;
        ListNode mergeCur = null;
        while (cur.next != null) {
            ListNode removedNode = cur.next;
            cur.next = removedNode.next;
            removedNode.next = null;
            if (mergeHead == null) {
                mergeHead = removedNode;
                mergeCur = removedNode;
            } else {
                mergeCur.next = removedNode;
                mergeCur = mergeCur.next;
            }
            if (cur.next != null) {
                cur = cur.next;
            }
        }
        cur.next = mergeHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cursor = head;
        ListNode evenHead = null;
        ListNode evenTail = null;
        while (cursor.next != null) {
            ListNode evenNode = cursor.next;
            if (evenHead == null) {
                evenHead = evenNode;
                evenTail = evenNode;
            } else {
                evenTail.next = evenNode;
                evenTail = evenTail.next;
            }
            if (evenNode.next != null) {
                cursor.next = evenNode.next;
                cursor = cursor.next;
            }
        }
        cursor.next = evenHead;
        return head;
    }
}
