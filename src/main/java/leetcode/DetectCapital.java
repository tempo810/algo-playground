package leetcode;

/**
 * @author tempo
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int totalCapitalCount = 0;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                totalCapitalCount++;
                if (totalCapitalCount != i + 1) {
                    return false;
                }
            } else if (totalCapitalCount > 1) {
                return false;
            }
        }
        return true;
    }
}
