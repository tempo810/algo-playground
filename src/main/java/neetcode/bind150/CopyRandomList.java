package neetcode.bind150;

import leetcode.datastructure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Node current = head;
        Node copiedListHead = new Node(0);
        Node copiedListCurrent = copiedListHead;
        Map<Node, Integer> originalNodeMap = new HashMap<>();
        Map<Integer, Node> nodes = new HashMap<>();

        // 1st pass
        int index = 0;
        while (current != null) {
            originalNodeMap.put(current, index);
            copiedListCurrent.next = new Node(current.val);
            nodes.put(index, copiedListCurrent.next);
            copiedListCurrent = copiedListCurrent.next;
            current = current.next;
            index++;
        }

        // 2nd pass
        current = head;
        copiedListCurrent = copiedListHead.next;
        while (current != null) {
            if (current.random != null) {
                copiedListCurrent.random = nodes.get(originalNodeMap.get(current.random));
            }
            current = current.next;
            copiedListCurrent = copiedListCurrent.next;
        }

        return copiedListHead.next;
    }
}
