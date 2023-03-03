package leetcode;

/**
 * @author tempo
 */
public class FindIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        char[] target = needle.toCharArray();
        char[] input = haystack.toCharArray();
        for (int i = 0; i < input.length - target.length + 1; i++) {
            if (input[i] == target[0] && match(input, i, target)) {
                return i;
            }
        }
        return -1;
    }

    private boolean match(char[] input, int start, char[] target) {
        for (int i = 1; i < target.length; i++) {
            if (input[start + i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
