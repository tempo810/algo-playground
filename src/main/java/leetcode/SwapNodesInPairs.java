package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;

        ListNode prev = result;

        while (prev.next != null && prev.next.next != null) {
            ListNode currentTail = prev.next;
            ListNode currentHead = prev.next.next;
            currentTail.next = currentHead.next;
            currentHead.next = currentTail;
            prev.next = currentHead;
            prev = currentTail;
        }

        return result.next;
    }
}
