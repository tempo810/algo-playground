package leetcode;

/**
 * @author Tempo
 */
public class ReverseOnlyLetter {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                chars[left] = (char) (chars[left] ^ chars[right]);
                chars[right] = (char) (chars[left] ^ chars[right]);
                chars[left] = (char) (chars[left] ^ chars[right]);
                left++;
                right--;
            }
            if (!Character.isLetter(chars[left])) {
                left++;
            }
            if (!Character.isLetter(chars[right])) {
                right--;
            }
        }
        return new String(chars);
    }
}
