package mit;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tempo
 */
public class StackWith2Queue {
    private Queue<Integer> main = new ArrayDeque<>();
    private Queue<Integer> secondary = new ArrayDeque<>();

    public void push(int element) {
        main.add(element);
    }

    public int pop() {
        if (main.isEmpty()) {
            throw new Error("stack is empty");
        }

        while (main.size() > 1) {
            secondary.add(main.remove());
        }
        Queue<Integer> tmp = main;
        main = secondary;
        secondary = tmp;
        return secondary.remove();
    }
}
