package leetcode.top;

import leetcode.datastructure.ListNode;

/**
 * @author tempo
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        ListNode list1Head = l1;
        ListNode list2Head = l2;
        boolean carry = false;

        while (list1Head != null || list2Head != null) {
            int firstValue = list1Head != null ? list1Head.val : 0;
            int secondValue = list2Head != null ? list2Head.val : 0;
            int sum = firstValue + secondValue;
            if (carry) {
                sum++;
            }
            carry = sum >= 10;
            ListNode newNode = new ListNode(sum % 10);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            if (list1Head != null) {
                list1Head = list1Head.next;
            }
            if (list2Head != null) {
                list2Head = list2Head.next;
            }

        }

        if (carry) {
            tail.next = new ListNode(1);
        }
        return head;
    }
}
