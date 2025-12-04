package neetcode.blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetFrequencies = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetFrequencies.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        int minStart = -1;
        int minEnd = -1;
        Map<Character, List<Integer>> currentFrequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (targetFrequencies.containsKey(s.charAt(i))) {
                currentFrequency.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
                boolean matched = true;
                int minIndex = Integer.MAX_VALUE;
                for (Map.Entry<Character, Integer> entry : targetFrequencies.entrySet()) {
                    final List<Integer> indices = currentFrequency.get(entry.getKey());
                    if (indices == null || indices.size() < entry.getValue()) {
                        matched = false;
                    } else if (indices.size() > entry.getValue()) {
                        indices.remove(0);
                    }
                    if (indices != null) {
                        minIndex = Math.min(minIndex, indices.get(0));
                    }
                }
                if (matched) {
                    if (minStart == -1) {
                        minStart = minIndex;
                        minEnd = i;
                    } else if (i - minIndex < minEnd - minStart) {
                        minStart = minIndex;
                        minEnd = i;
                    }
                }
            }
        }
        if (minStart == -1) {
            return "";
        }
        return s.substring(minStart, minEnd + 1);
    }
}
