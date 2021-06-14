package mit;

import java.util.Stack;

/**
 * @author Tempo
 */
public class QueueWith2Stack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> queue = new Stack<>();

    public void add(int element) {
        stack.push(element);
    }

    public int get() {
        if (queue.isEmpty()) {
            if (stack.isEmpty()) {
                throw new Error("queue is empty");
            }
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.pop();
    }
}
