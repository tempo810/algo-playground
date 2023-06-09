package leetcode;

/**
 * @author tempo
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = 'z' + 1;
        for (char letter : letters) {
            if (letter > target) {
                result = (char) Math.min(result, letter);
            }
        }
        if (result == 'z' + 1) {
            result = letters[0];
        }
        return result;
    }
}
