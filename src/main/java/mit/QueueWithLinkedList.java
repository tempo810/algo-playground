package mit;

/**
 * @author Tempo
 */
public class QueueWithLinkedList {
    private SinglyLinkedListNode<Integer> head;
    private SinglyLinkedListNode<Integer> tail;

    public void enqueue(int element) {
        var node = new SinglyLinkedListNode<Integer>();
        node.element = element;
        if (head == null) {
            head = node;
        }
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
    }

    public int dequeue() {
        if (head == null) {
            throw new Error("queue is empty");
        }
        int val = head.element;
        head = head.next;
        return val;
    }
}
