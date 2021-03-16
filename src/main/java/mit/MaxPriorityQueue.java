package mit;

/**
 * @author tempo
 */
public class MaxPriorityQueue {
    private int element = 0;
    private int[] queue;

    public MaxPriorityQueue(int initialCapacity) {
        queue = new int[initialCapacity];
    }

    public MaxPriorityQueue() {
        this(10);
    }

    public int maxElement() {
        if (element < 1) {
            throw new Error("queue is empty");
        }
        return queue[0];
    }

    public int extractMax() {
        int max = maxElement();
        element--;
        if (element > 0) {
            queue[0] = queue[element];
            Heap.maxHeapify(queue, 1, element);
        }
        return max;
    }

    public void increase(int index, int value) {
        if (value < queue[index]) {
            throw new Error("new key is smaller than current key");
        }

        queue[index] = value;
        int i = index + 1;

        while (i > 1 && queue[(i / 2) - 1] < queue[i - 1]) {
            int temp = queue[i - 1];
            queue[i - 1] = queue[(i / 2) - 1];
            queue[(i / 2) - 1] = temp;
            i /= 2;
        }
    }

    public void increaseKey(int index, int value) {
        int i = index + 1;

        while (i > 1 && queue[(i / 2) - 1] < value) {
            queue[i - 1] = queue[(i / 2) - 1];
            i /= 2;
        }
        queue[i - 1] = value;
    }

    public void add(int value) {
        if (element == queue.length) {
            int[] expandQueue = new int[queue.length * 2];
            System.arraycopy(queue, 0, expandQueue, 0, queue.length);
            queue = expandQueue;
        }

        queue[element] = Integer.MIN_VALUE;
        increase(element, value);
        element++;
    }

    public void delete(int index) {
        if (index <= 0 || index < element) {
            throw new Error("index out of bound");
        }
        queue[index - 1] = queue[element--];
        Heap.maxHeapify(queue, index, element);
    }

    public int size() {
        return element;
    }
}
