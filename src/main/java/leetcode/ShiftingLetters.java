package leetcode;

/**
 * @author Tempo
 */
public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        int shift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            int shiftedChar = (chars[i] + shift) % 123;
            if (shiftedChar < 97) {
                shiftedChar += 97;
            }
            chars[i] = (char) shiftedChar;
        }
        return new String(chars);
    }
}
