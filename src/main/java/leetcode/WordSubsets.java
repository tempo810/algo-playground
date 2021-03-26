package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tempo
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] globalHash = new int[26];
        for (String subWord : B) {
            int[] currentHash = new int[26];
            char[] chars = subWord.toCharArray();
            for (char c : chars) {
                if (++currentHash[c - 'a'] > globalHash[c - 'a']) {
                    globalHash[c - 'a'] = currentHash[c - 'a'];
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : A) {
            int[] hash = Arrays.copyOf(globalHash, globalHash.length);
            char[] chars = word.toCharArray();
            for (char c : chars) {
                hash[c - 'a']--;
            }

            boolean isUniversal = true;
            for (int count : hash) {
                if (count > 0) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(word);
            }
        }
        return result;
    }
}
