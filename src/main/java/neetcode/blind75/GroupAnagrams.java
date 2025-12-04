package neetcode.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        Map<String, List<String>> groupAnagramsMap = new HashMap<>();
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[i]; j++) {
                    sb.append(i + 'a');
                }
            }
            groupAnagramsMap.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(str);
            sb.setLength(0);
            Arrays.fill(chars, 0);
        }
        return new ArrayList<>(groupAnagramsMap.values());
    }
}
