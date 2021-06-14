package mit;

/**
 * @author Tempo
 */
public class StackWithLinkedList {
    private SinglyLinkedListNode<Integer> head;

    public void push(int element) {
        var node = new SinglyLinkedListNode<Integer>();
        node.element = element;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public int pop() {
        if (head == null) {
            throw new Error("stack is empty");
        }
        int val = head.element;
        head = head.next;
        return val;
    }
}
