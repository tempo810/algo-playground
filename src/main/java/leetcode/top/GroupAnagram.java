package leetcode.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charOccurrences = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                charOccurrences.compute(str.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            }
            anagramMap.computeIfAbsent(charOccurrences, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
