package mit;

/**
 * @author Tempo
 */
public class DoubleStack {
    private final int[] stack;
    private int stack1;
    private int stack2;

    public DoubleStack(int size) {
        stack = new int[size];
        stack1 = 0;
        stack2 = size - 1;
    }

    public void stack1Push(int element) {
        if (stack1 > stack2) {
            throw new Error("stack is full");
        }
        stack[stack1++] = element;
    }

    public void stack2Push(int element) {
        if (stack1 > stack2) {
            throw new Error("stack is full");
        }
        stack[stack2--] = element;
    }

    public int stack1Pop() {
        if (stack1 == 0) {
            throw new Error("stack 1 is empty");
        }
        return stack[--stack1];
    }

    public int stack2Pop() {
        if (stack2 == stack.length - 1) {
            throw new Error("stack 2 is empty");
        }
        return stack[++stack2];
    }

}
