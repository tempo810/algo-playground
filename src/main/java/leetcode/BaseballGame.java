package leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiConsumer;

/**
 * @author Tempo
 */
public class BaseballGame {
    private static final Map<String, BiConsumer<String, Stack<Integer>>> FUNCTION = Map.of(
            "C", (input, stack) -> stack.pop(),
            "D", (input, stack) -> stack.push(stack.peek() * 2),
            "+", (input, stack) -> stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2))
    );

    public int calPoints(String[] ops) {
        Stack<Integer> point = new Stack<>();
        for (String op : ops) {
            FUNCTION.getOrDefault(op, (input, stack) -> stack.push(Integer.valueOf(input))).accept(op, point);
        }
        int result = 0;
        while (!point.isEmpty()) {
            result += point.pop();
        }
        return result;
    }
}
