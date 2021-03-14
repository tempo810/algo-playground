package leetcode;

import leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class SwappingNodeInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int temp = nodes.get(k - 1).val;
        nodes.get(k - 1).val = nodes.get(nodes.size() - k).val;
        nodes.get(nodes.size() - k).val = temp;
        return head;
    }

    // in place swap
    public ListNode swapNodesV2(ListNode head, int k) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        int count = 1;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            count++;
            if (count == k) {
                slowNode = fastNode;
            }
        }

        int length = count;
        count = 0;
        fastNode = head;
        while (count < length - k) {
            fastNode = fastNode.next;
            count++;
        }
        int tmp = fastNode.val;
        fastNode.val = slowNode.val;
        slowNode.val = tmp;
        return head;
    }
}
