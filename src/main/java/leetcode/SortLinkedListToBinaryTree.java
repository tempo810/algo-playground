package leetcode;

import leetcode.datastructure.ListNode;
import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class SortLinkedListToBinaryTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        if (size == 1) {
            return new TreeNode(head.val);
        }

        if (size == 2) {
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }

        int mid = size / 2 - 1;
        int cursor = 0;
        tmp = head;

        while (cursor < mid) {
            tmp = tmp.next;
            cursor++;
        }

        TreeNode root = new TreeNode(tmp.next.val);
        ListNode right = tmp.next.next;
        tmp.next.next = null;
        root.right = sortedListToBST(right);
        tmp.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
