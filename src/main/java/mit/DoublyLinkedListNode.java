package mit;

/**
 * @author Tempo
 */
public class DoublyLinkedListNode<T> {
    public static <T> DoublyLinkedListNode<T> getSentinel() {
        var node = new DoublyLinkedListNode<T>(null);
        node.next = node;
        node.prev = node.next;
        return node;
    }

    DoublyLinkedListNode<T> prev;
    DoublyLinkedListNode<T> next;
    T element;
    String key;

    public DoublyLinkedListNode(String key) {
        this.key = key;
    }
}
