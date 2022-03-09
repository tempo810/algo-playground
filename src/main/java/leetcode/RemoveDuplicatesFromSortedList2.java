package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode resultHead = new ListNode(0);
        ListNode last = resultHead;
        ListNode current = head;

        while (current != null) {
            if (current.next == null) {
                last.next = current;
                last = last.next;
                break;
            } else if (current.val != current.next.val) {
                last.next = current;
                last = last.next;
                current = current.next;
            } else {
                int duplicatedValue = current.val;
                while (current != null && current.val == duplicatedValue) {
                    current = current.next;
                }
            }
        }
        last.next = null;
        return resultHead.next;
    }
}
