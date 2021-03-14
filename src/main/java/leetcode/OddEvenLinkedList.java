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
}
