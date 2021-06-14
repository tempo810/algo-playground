package mit;

/**
 * @author Tempo
 */
public class SinglyLinkedListNode<T> {
    public T element;
    public SinglyLinkedListNode<T> next;

    public static <T> SinglyLinkedListNode<T> flip(SinglyLinkedListNode<T> root) {
        SinglyLinkedListNode<T> prev = null;
        SinglyLinkedListNode<T> current = root;
        while (current != null) {
            SinglyLinkedListNode<T> tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }

    public SinglyLinkedListNode() {
    }

    public SinglyLinkedListNode(T element) {
        this.element = element;
    }
}
