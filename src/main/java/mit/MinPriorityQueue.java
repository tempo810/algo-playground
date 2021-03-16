package mit;

/**
 * @author tempo
 */
public class MinPriorityQueue {
    private int element = 0;
    private int[] queue;

    public MinPriorityQueue(int initialCapacity) {
        queue = new int[initialCapacity];
    }

    public MinPriorityQueue() {
        this(10);
    }

    public int minElement() {
        if (element < 1) {
            throw new Error("queue is empty");
        }
        return queue[0];
    }

    public int extractMin() {
        int max = minElement();
        element--;
        if (element > 0) {
            queue[0] = queue[element];
            Heap.minHeapify(queue, 1, element);
        }
        return max;
    }

    public void decrease(int index, int value) {
        if (value > queue[index]) {
            throw new Error("new key is larger than current key");
        }
        queue[index] = value;
        int i = index + 1;

        while (i > 1 && queue[(i / 2) - 1] > queue[i - 1]) {
            int temp = queue[i - 1];
            queue[i - 1] = queue[(i / 2) - 1];
            queue[(i / 2) - 1] = temp;
            i /= 2;
        }
    }

    public void add(int value) {
        if (element == queue.length) {
            int[] expandQueue = new int[queue.length * 2];
            System.arraycopy(queue, 0, expandQueue, 0, queue.length);
            queue = expandQueue;
        }

        queue[element] = Integer.MAX_VALUE;
        decrease(element, value);
        element++;
    }

    public int size() {
        return element;
    }
}
