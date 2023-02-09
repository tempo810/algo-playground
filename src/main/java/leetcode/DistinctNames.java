package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class DistinctNames {
    public long distinctNames(String[] ideas) {
        Set<String>[] indexByChar = new Set[26];
        for (int i = 0; i < indexByChar.length; i++) {
            indexByChar[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            indexByChar[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long total = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                final Set<String> setA = indexByChar[i];
                final Set<String> setB = indexByChar[j];
                if (setA.size() > 0 && setB.size() > 0) {
                    int duplicated = 0;
                    for (String setBString : setB) {
                        if (setA.contains(setBString)) {
                            duplicated++;
                        }
                    }
                    total += (long) (setA.size() - duplicated) * (setB.size() - duplicated) * 2;
                }
            }
        }
        return total;
    }
}
