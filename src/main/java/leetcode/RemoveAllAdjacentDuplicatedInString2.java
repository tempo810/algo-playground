package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Tempo
 */
public class RemoveAllAdjacentDuplicatedInString2 {

    public String removeDuplicates(String s, int k) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(new Node('Z'));

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            Node lastNode = deque.getLast();
            if (lastNode.key == aChar) {
                if (lastNode.occurrence + 1 == k) {
                    deque.removeLast();
                } else {
                    lastNode.occurrence++;
                }
            } else {
                deque.add(new Node(aChar));
            }
        }

        deque.removeFirst();
        StringBuilder sb = new StringBuilder();
        for (Node node : deque) {
            for (int i = 0; i < node.occurrence; i++) {
                sb.append(node.key);
            }
        }
        return sb.toString();
    }

    private static class Node {
        private final char key;
        private int occurrence = 1;

        private Node(char key) {
            this.key = key;
        }
    }
}
