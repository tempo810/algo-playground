package leetcode;

/**
 * @author tempo
 */
public class ReverseVowelOfAString {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int high = word.length - 1;
        int low = 0;
        while (low < high) {
            while (low < high && !isVowel(word[low])) {
                low++;
            }

            while (low < high && !isVowel(word[high])) {
                high--;
            }

            if (low != high) {
                word[low] ^= word[high];
                word[high] ^= word[low];
                word[low] ^= word[high];
                low++;
                high--;
            }
        }
        return new String(word);
    }

    private boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'
                || character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U';
    }
}
