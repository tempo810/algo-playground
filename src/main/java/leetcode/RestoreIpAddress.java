package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tempo
 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        Deque<Integer> partial = new ArrayDeque<>();
        List<String> results = new ArrayList<>();
        restoreIpAddresses(s, 0, partial, results);
        return results;
    }

    private void restoreIpAddresses(String s, int start, Deque<Integer> partial, List<String> results) {
        int size = partial.size();
        if (size == 4) {
            if (start == s.length()) {
                results.add(partial.stream().map(String::valueOf).collect(Collectors.joining(".")));
            }
        } else if (s.length() - start >= 4 - size && s.length() - start <= (4 - size) * 3) {
            for (int i = 0; i < Math.min(s.length() - start, 3); i++) {
                int val = Integer.parseInt(s.substring(start, start + i + 1));
                if (val <= 255) {
                    partial.add(val);
                    restoreIpAddresses(s, start + i + 1, partial, results);
                    partial.removeLast();
                }
                if (val == 0) {
                    break;
                }
            }
        }
    }
}
