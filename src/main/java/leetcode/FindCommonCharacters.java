package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < A[0].length(); i++) {
            chars.compute(A[0].charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> currentChars = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                currentChars.compute(A[i].charAt(j), (k, v) -> v == null ? 1 : v + 1);
            }
            for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
                entry.setValue(Math.min(entry.getValue(), currentChars.getOrDefault(entry.getKey(), 0)));
            }
        }
        List<String> results = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                results.add(String.valueOf(entry.getKey()));
            }
        }
        return results;
    }

    public List<String> commonCharsV2(String[] A) {
        int[] result = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            result[A[0].charAt(i) - 'a']++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                cur[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < cur.length; j++) {
                result[j] = Math.min(cur[j], result[j]);
            }
        }

        List<String> results = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i]; j++) {
                results.add(Character.toString(i + 'a'));
            }
        }
        return results;
    }
}
