package mit;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tempo
 */
public class StackWith2Queue {
    private final Queue<Integer> queue = new ArrayDeque<>();
    private final Queue<Integer> stack = new ArrayDeque<>();

    public void push(int element) {
        queue.add(element);
    }

    public int pop() {
        if (stack.isEmpty()) {
            if (queue.isEmpty()) {
                throw new Error("stack is empty");
            }
            while (!queue.isEmpty()) {
                stack.add(queue.remove());
            }
        }
        int val = stack.remove();
        return val;
    }
}
