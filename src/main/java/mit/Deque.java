package mit;

/**
 * @author Tempo
 */
public class Deque {
    private final int[] arr;
    private int head = -1;
    private int tail = 0;

    public Deque(int size) {
        arr = new int[size];
    }

    public void headEnqueue(int element) {
        if (isFull()) {
            throw new Error("deque is full");
        }
        if (head == -1) {
            head = 0;
            tail = 0;
        } else if (head == 0) {
            head = arr.length - 1;
        } else {
            head--;
        }
        arr[head] = element;
    }

    public void tailEnqueue(int element) {
        if (isFull()) {
            throw new Error("deque is full");
        }
        if (head == -1) {
            head = 0;
            tail = 0;
        } else if (tail == arr.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        arr[tail] = element;
    }

    public int headDeque() {
        if (isEmpty()) {
            throw new Error("deque is empty");
        }
        int element = arr[head];
        if (head == tail) {
            head = -1;
            tail = -1;
        } else if (head == arr.length - 1) {
            head = 0;
        } else {
            head++;
        }
        return element;
    }

    public int tailDeque() {
        if (isEmpty()) {
            throw new Error("deque is empty");
        }
        int element = arr[tail];
        if (head == tail) {
            head = -1;
            tail = -1;
        } else if (tail == 0) {
            tail = arr.length - 1;
        } else {
            tail--;
        }
        return element;
    }

    private boolean isFull() {
        return (head == 0 && tail == arr.length - 1) || head == tail + 1;
    }

    private boolean isEmpty() {
        return head == -1;
    }
}
