package leetcode;

import leetcode.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tempo
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode cursor = head;
        while (cursor != null) {
            heap.offer(cursor);
            cursor = cursor.next;
        }
        ListNode resultHead = heap.poll();
        cursor = resultHead;
        while (!heap.isEmpty()) {
            cursor.next = heap.poll();
            cursor = cursor.next;
        }
        cursor.next = null;
        return resultHead;
    }

    public ListNode sortListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        return merge(sortListV2(head), sortListV2(right));
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode cursor = null;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                if (head == null) {
                    head = left;
                    cursor = head;
                } else {
                    cursor.next = left;
                    cursor = cursor.next;
                }
                left = left.next;

            } else {
                if (head == null) {
                    head = right;
                    cursor = head;
                } else {
                    cursor.next = right;
                    cursor = cursor.next;
                }
                right = right.next;
            }
        }

        cursor.next = left != null ? left : right;
        return head;
    }
}
