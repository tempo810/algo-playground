package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        boolean[] picked = new boolean[bank.length];
        int depth = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            depth += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String lastGene = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    if (!picked[j] && isNextGen(lastGene, bank[j])) {
                        if (bank[j].equals(end)) {
                            return depth;
                        } else {
                            queue.add(bank[j]);
                            picked[j] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean isNextGen(String oldGene, String newGene) {
        boolean diff = false;
        for (int i = 0; i < 8; i++) {
            if (oldGene.charAt(i) != newGene.charAt(i)) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                }
            }
        }
        return diff;
    }
}
