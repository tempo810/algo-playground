package leetcode.top;

import leetcode.datastructure.ListNode;

/**
 * @author tempo
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        boolean isOdd = true;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (isOdd) {
                if (oddHead == null) {
                    oddHead = currentNode;
                } else {
                    oddTail.next = currentNode;
                }
                oddTail = currentNode;
                isOdd = false;
            } else {
                if (evenHead == null) {
                    evenHead = currentNode;
                } else {
                    evenTail.next = currentNode;
                }
                evenTail = currentNode;
                isOdd = true;
            }
            currentNode = currentNode.next;
        }
        oddTail.next = evenHead;
        if (evenTail != null) {
            evenTail.next = null;
        }
        return oddHead;
    }
}
