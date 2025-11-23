package leetcode.leetcode75;

/**
 * @author tempo
 */
public class ReverseLinkedList {

    // 3 --> 2 --> 1 --> null
    public ListNode reverseList(ListNode head) {
        ListNode cursor = head; // unprocessed head
        ListNode reversedList = null; // node to be prepended (reversed)
        while (cursor != null) {
            ListNode tmp = cursor.next;
            cursor.next = reversedList;
            reversedList = cursor;
            cursor = tmp;
        }
        return reversedList;
    }

    public static class ListNode {
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
