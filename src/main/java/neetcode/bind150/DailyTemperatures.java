package neetcode.bind150;

import java.util.Stack;

/**
 * @author tempo
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> minStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!minStack.isEmpty() && minStack.peek()[0] < currentTemp) {
                int prevIndex = minStack.pop()[1];
                result[prevIndex] = i - prevIndex;
            }
            minStack.add(new int[]{currentTemp, i});
        }
        return result;
    }
}
