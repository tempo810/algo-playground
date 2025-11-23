package leetcode.leetcode75;

/**
 * @author tempo
 */
public class ReverseVowelOfAString {
    boolean[] isVowels = new boolean[128];

    public String reverseVowels(String s) {
        for (char c : "aeiouAEIOU".toCharArray()) {
            this.isVowels[c] = true;
        }

        final char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            if (!isVowels[charArray[i]]) {
                i++;
            } else if (isVowels[charArray[j]]) {
                char c1 = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = c1;
                i++;
                j--;
            } else {
                j--;
            }
        }
        return new String(charArray);
    }
}
