package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Tempo
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = s.length();
        int[] targetFrequency = getFrequency(t);
        Map<Character, Queue<Integer>> partial = initializePartialTable(targetFrequency);
        boolean found = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            Queue<Integer> indices = partial.get(s.charAt(i));
            if (indices != null) {
                indices.add(i);
                if (indices.size() > targetFrequency[s.charAt(i) - 'A']) {
                    indices.remove();
                }
                if (!found) {
                    found = checkFound(targetFrequency, partial);
                }
                if (found) {
                    int localEnd = getHighest(new ArrayList<>(partial.values()));
                    if (localEnd - i < end - start) {
                        end = localEnd;
                        start = i;
                    }
                }
            }
        }
        return found ? s.substring(start, end + 1) : "";
    }

    private int getHighest(List<Queue<Integer>> indices) {
        int highest = Integer.MIN_VALUE;
        for (Queue<Integer> index : indices) {
            highest = Math.max(highest, index.peek());
        }
        return highest;
    }

    private boolean checkFound(int[] targetFrequency, Map<Character, Queue<Integer>> partial) {
        for (Map.Entry<Character, Queue<Integer>> entry : partial.entrySet()) {
            if (targetFrequency[entry.getKey() - 'A'] != entry.getValue().size()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Queue<Integer>> initializePartialTable(int[] targetFrequency) {
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < targetFrequency.length; i++) {
            if (targetFrequency[i] > 0) {
                map.put((char) (i + 'A'), new ArrayDeque<>());
            }
        }
        return map;
    }

    private int[] getFrequency(String subString) {
        int[] hash = new int[64];
        for (int i = 0; i < subString.length(); i++) {
            hash[subString.charAt(i) - 'A']++;
        }
        return hash;
    }
}
