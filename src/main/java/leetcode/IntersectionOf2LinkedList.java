package leetcode;

/**
 * @author tempo
 */
public class IntersectionOf2LinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tail = headA;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = headA;
        ListNode fast = headB;
        ListNode slow = headB;
        ListNode intersect = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                slow = headB;
                while (!fast.equals(slow)) {
                    fast = fast.next;
                    slow = slow.next;
                }
                intersect = fast;
                break;
            }
        }
        tail.next = null;
        return intersect;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
