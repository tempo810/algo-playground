package leetcode.leetcode75;

/**
 * @author tempo
 */
public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headOfSecondSegment = slow.next;
        ListNode headOfReversedSegment = null;
        while (headOfSecondSegment != null) {
            ListNode tmp = headOfSecondSegment.next;
            headOfSecondSegment.next = headOfReversedSegment;
            headOfReversedSegment = headOfSecondSegment;
            headOfSecondSegment = tmp;
        }

        int result = 0;
        ListNode headOfFirstSegment = head;
        while (headOfReversedSegment != null) {
            result = Math.max(result, headOfFirstSegment.val + headOfReversedSegment.val);
            headOfReversedSegment = headOfReversedSegment.next;
            headOfFirstSegment = headOfFirstSegment.next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
