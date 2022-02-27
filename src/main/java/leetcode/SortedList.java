package leetcode;

import leetcode.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class SortedList {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(node -> node.val));

        ListNode cursor = head;
        while (cursor != null) {
            heap.add(cursor);
            cursor = cursor.next;
        }

        cursor = heap.poll();
        ListNode result = cursor;

        while (!heap.isEmpty()) {
            cursor.next = heap.poll();
            cursor = cursor.next;
        }

        cursor.next = null;
        return result;
    }
}
