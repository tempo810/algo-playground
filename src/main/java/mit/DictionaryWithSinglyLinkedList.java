package mit;

/**
 * @author Tempo
 */
public class DictionaryWithSinglyLinkedList {
    private final SinglyLinkedListNode<String> head = new SinglyLinkedListNode<>();

    // O(1)
    public void insert(String val) {
        var node = new SinglyLinkedListNode<String>();
        node.element = val;
        node.next = head.next;
        head.next = node;
    }

    // O(n)
    public SinglyLinkedListNode<String> search(String val) {
        var node = head.next;
        while (node != null && !val.equals(node.element)) {
            node = node.next;
        }
        return node;
    }

    public boolean delete(String val) {
        var prev = head;
        while (prev.next != null && !val.equals(prev.next.element)) {
            prev = prev.next;
        }
        if (prev.next == null) {
            return false;
        }

        prev.next = prev.next.next;
        return true;
    }
}
