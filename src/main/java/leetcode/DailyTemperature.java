package leetcode;

import java.util.ArrayDeque;
import java.util.TreeMap;

/**
 * @author Tempo
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        int[] results = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            int next = i + 1;
            while (next < T.length) {
                if (T[i] < T[next]) {
                    break;
                } else {
                    next++;
                }
            }
            if (next == T.length) {
                results[i] = 0;
            } else {
                results[i] = next - i;
            }
        }
        return results;
    }

    public int[] dailyTempV2(int[] T) {
        TreeMap<Integer, ArrayDeque<Integer>> temps = new TreeMap<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            Integer pastTemp = temps.lowerKey(T[i]);
            while (pastTemp != null) {
                ArrayDeque<Integer> days = temps.remove(pastTemp);
                while (!days.isEmpty()) {
                    Integer day = days.pop();
                    result[day] = i - day;
                }
                pastTemp = temps.lowerKey(T[i]);
            }
            temps.computeIfAbsent(T[i], key -> new ArrayDeque<>()).add(i);
        }
        return result;
    }
}
