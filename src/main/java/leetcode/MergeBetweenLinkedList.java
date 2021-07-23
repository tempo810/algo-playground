package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class MergeBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int cursor = 0;
        ListNode left = list1;
        while (cursor < a - 1) {
            left = left.next;
            cursor++;
        }
        ListNode right = left.next;
        left.next = list2;
        while (cursor < b) {
            right = right.next;
            cursor++;
        }
        while (left.next != null) {
            left = left.next;
        }
        left.next = right;
        return list1;
    }
}
