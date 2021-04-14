package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode headPartitionHead = null;
        ListNode headPartitionTail = null;
        ListNode tailPartitionHead = null;
        ListNode tailPartitionTail = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (headPartitionHead == null) {
                    headPartitionHead = cur;
                } else {
                    headPartitionTail.next = cur;
                }
                headPartitionTail = cur;
            } else {
                if (tailPartitionHead == null) {
                    tailPartitionHead = cur;
                } else {
                    tailPartitionTail.next = cur;
                }
                tailPartitionTail = cur;
            }
            cur = cur.next;
        }
        if (tailPartitionTail != null) {
            tailPartitionTail.next = null;
        }

        if (headPartitionTail != null) {
            headPartitionTail.next = tailPartitionHead;
            return headPartitionHead;
        }
        return tailPartitionHead;
    }
}
