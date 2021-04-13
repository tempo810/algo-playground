package leetcode;

/**
 * @author Tempo
 */

public class LastStringInLexicographicalOrder {
    //wip
    public String lastSubstring(String s) {
        int maxIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) > s.charAt(maxIndex)) {
                maxIndex = i;
            } else if (s.charAt(i) == s.charAt(maxIndex)) {
                maxIndex = s.substring(i).compareTo(s.substring(maxIndex)) > 0 ? i : maxIndex;
            }
        }
        return s.substring(maxIndex);
    }
}
