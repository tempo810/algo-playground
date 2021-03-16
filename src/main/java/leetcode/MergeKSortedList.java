package leetcode;

import leetcode.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tempo
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<KIndexedListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.node.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode headNode = lists[i];
            if (headNode != null) {
                queue.add(new KIndexedListNode(i, headNode));
                lists[i] = headNode.next;
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode head = null;
        ListNode cur = null;
        while (!queue.isEmpty()) {
            KIndexedListNode smallestNode = queue.remove();
            if (head == null) {
                head = smallestNode.node;
                cur = smallestNode.node;
            } else {
                cur.next = smallestNode.node;
                cur = cur.next;
            }
            ListNode next = lists[smallestNode.index];
            if (next != null) {
                queue.add(new KIndexedListNode(smallestNode.index, next));
                lists[smallestNode.index] = next.next;
            }
        }
        cur.next = null;
        return head;
    }

    public static class KIndexedListNode {
        public final ListNode node;
        public final int index;

        public KIndexedListNode(int index, ListNode node) {
            this.index = index;
            this.node = node;
        }
    }
}
