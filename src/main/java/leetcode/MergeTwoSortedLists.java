package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        while (l1Head != null && l2Head != null) {
            if (l1Head.val < l2Head.val) {
                current.next = l1Head;
                l1Head = l1Head.next;
            } else {
                current.next = l2Head;
                l2Head = l2Head.next;
            }
            current = current.next;
        }

        if (l1Head != null) {
            current.next = l1Head;
        } else {
            current.next = l2Head;
        }

        return root.next;
    }
}
