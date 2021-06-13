package mit;

/**
 * @author Tempo
 */
public class Queue {
    private final int[] queue;
    private int head;
    private int tail;

    public Queue(int size) {
        queue = new int[size];
        head = -1;
        tail = -1;
    }

    public void enqueue(int element) {
        if (tail + 1 == head || (tail == queue.length - 1 && (head == 0 || head == -1))) {
            throw new Error("queue is full");
        }

        tail = tail == queue.length - 1 ? 0 : tail + 1;
        queue[tail] = element;
    }

    public int deque() {
        if (head == tail) {
            throw new Error("queue is empty");
        }
        head = head == queue.length - 1 ? 0 : head + 1;
        return queue[head];
    }
}
