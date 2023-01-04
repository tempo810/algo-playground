package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int rounds = 0;
        int uncompletedTask = 0;
        for (int task : tasks) {
            int frequency = frequencies.compute(task, (k, v) -> v == null ? 1 : v + 1);
            if (frequency == 1) {
                uncompletedTask++;
            } else if (frequency == 2) {
                uncompletedTask--;
            }
            if (frequency % 3 == 1) {
                rounds++;
            }
        }
        return uncompletedTask == 0 ? rounds : -1;
    }
}
