package mit;

/**
 * @author Tempo
 */
public class LinkedList {
    private final DoublyLinkedListNode<Integer> sentinel = DoublyLinkedListNode.getSentinel();

    // assume no key conflict
    public void add(int val) {
        var node = new DoublyLinkedListNode<Integer>(String.valueOf(val));
        node.element = val;
        node.next = sentinel;
        node.prev = sentinel.prev;

        sentinel.prev.next = node;
        sentinel.prev = node;
    }

    public boolean search(int val) {
        sentinel.key = String.valueOf(val);
        var node = sentinel.next;
        while (!sentinel.key.equals(node.key)) {
            node = node.next;
        }
        return node.element != null;
    }
}
