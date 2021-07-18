package leetcode;

import leetcode.datastructure.ListNode;

/**
 * @author Tempo
 */
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        int count = 1;
        ListNode returnHead = null;

        ListNode kGroupHead = head;
        ListNode kGroupTail = null;

        ListNode lastTail = null;
        ListNode nextHead = null;

        while (kGroupHead != null) {
            if (count < k) {
                kGroupTail = kGroupTail != null ? kGroupTail.next : head.next;
                if (kGroupTail == null) {
                    break;
                }
                nextHead = kGroupTail.next;
                count++;
            } else {

                ListNode before = null;
                ListNode current = kGroupHead;
                ListNode next = null;
                while (count > 0) {
                    next = current.next;
                    current.next = before;
                    before = current;
                    current = next;
                    count--;
                }

                if (returnHead == null) {
                    returnHead = before;
                } else {
                    lastTail.next = before;
                }
                kGroupHead.next = nextHead;
                lastTail = kGroupHead;
                kGroupHead = nextHead;
                kGroupTail = nextHead;
                count = 1;
            }
        }
        return returnHead;
    }

    public ListNode reverseNodeInKGroupV2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode cursor = head;
        while (count < k && cursor.next != null) {
            cursor = cursor.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode currentTail = head;
        ListNode nextHead = cursor.next;
        count = 0;
        ListNode prev = null;
        ListNode temp = null;
        while (count < k) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            count++;
        }

        currentTail.next = reverseKGroup(nextHead, k);
        return cursor;
    }
}
