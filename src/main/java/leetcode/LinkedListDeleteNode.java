package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author tempo
 */
public class LinkedListDeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
