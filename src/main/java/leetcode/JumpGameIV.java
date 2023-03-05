package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author tempo
 */
public class JumpGameIV {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            positions.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[arr.length];
        int step = 0;
        Queue<Integer> moves = new ArrayDeque<>();
        moves.add(0);
        visited[0] = true;

        while (!moves.isEmpty()) {
            int size = moves.size();
            for (int i = 0; i < size; i++) {
                final Integer currentStep = moves.poll();
                if (currentStep == arr.length - 1) {
                    return step;
                }
                final List<Integer> nextSteps = positions.remove(arr[currentStep]);
                if (nextSteps != null) {
                    for (Integer nextStep : nextSteps) {
                        if (!visited[nextStep]) {
                            visited[nextStep] = true;
                            moves.add(nextStep);
                        }
                    }
                }
                if (currentStep - 1 > 0 && !visited[currentStep - 1]) {
                    visited[currentStep - 1] = true;
                    moves.add(currentStep - 1);
                }
                if (currentStep + 1 < arr.length && !visited[currentStep + 1]) {
                    visited[currentStep + 1] = true;
                    moves.add(currentStep + 1);
                }
            }
            step++;
        }
        return step;
    }
}
