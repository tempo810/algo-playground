package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class SplitLinkedListInPart {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int total = countNode(head);
        ListNode[] nodes = new ListNode[k];
        int remainder = total < k ? 0 : total % k;
        int splitSize = total / k;

        ListNode cursor = head;
        for (int i = 0; i < k; i++) {
            nodes[i] = cursor;
            ListNode tail = cursor;
            int currentSplit = 1;
            while (tail != null && currentSplit < splitSize) {
                tail = tail.next;
                currentSplit++;
            }
            if (tail != null && i < remainder) {
                tail = tail.next;
            }

            cursor = tail == null ? null : tail.next;
            if (tail != null) {
                tail.next = null;
            }
        }
        return nodes;
    }

    private int countNode(ListNode head) {
        int total = 0;
        ListNode cursor = head;
        while (cursor != null) {
            cursor = cursor.next;
            total++;
        }
        return total;
    }
}
