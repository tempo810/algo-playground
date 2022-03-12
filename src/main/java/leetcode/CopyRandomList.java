package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node pointer = head;
        nodeMap.put(pointer, new Node(pointer.val));

        while (pointer.next != null) {
            Node newNode = new Node(pointer.next.val);
            nodeMap.put(pointer.next, newNode);
            nodeMap.get(pointer).next = newNode;
            pointer = pointer.next;
        }

        pointer = head;
        while (pointer != null) {
            nodeMap.get(pointer).random = nodeMap.get(pointer.random);
            pointer = pointer.next;
        }

        return nodeMap.get(head);
    }

    private static final class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
