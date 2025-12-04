package leetcode.top;

import leetcode.datastructure.ListNode;

/**
 * @author tempo
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tailA = headA;
        int countListA = 1;
        while (tailA.next != null) {
            countListA++;
            tailA = tailA.next;
        }

        ListNode tailB = headB;
        int countListB = 1;
        while (tailB.next != null) {
            countListB++;
            tailB = tailB.next;
        }

        if (tailA != tailB) {
            return null;
        }

        tailA = headA;
        tailB = headB;

        int offset = Math.abs(countListA - countListB);
        if (offset != 0) {
            if (countListA > countListB) {
                for (int i = 0; i < offset; i++) {
                    tailA = tailA.next;
                }
            } else {
                for (int i = 0; i < offset; i++) {
                    tailB = tailB.next;
                }
            }
        }

        while (tailA != tailB) {
            tailA = tailA.next;
            tailB = tailB.next;
        }

        return tailA;
    }
}
