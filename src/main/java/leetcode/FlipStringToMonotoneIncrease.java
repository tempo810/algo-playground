package leetcode;

/**
 * @author tempo
 */
public class FlipStringToMonotoneIncrease {
    public int minFlipsMonoIncr(String s) {
        final char[] chars = s.toCharArray();
        final int[] flipToOne = new int[chars.length + 1];
        boolean foundOne = false;
        for (int i = 0; i < chars.length; i++) {
            flipToOne[i + 1] = flipToOne[i];
            if (!foundOne && chars[i] == '1') {
                foundOne = true;
            }

            if (foundOne && chars[i] == '0') {
                flipToOne[i + 1]++;
            }
        }

        int minFlip = flipToOne[flipToOne.length - 1];
        boolean foundZero = false;
        int flipToZero = 0;
        for (int i = chars.length - 1; i >= 0; i--) {

            if (!foundZero && chars[i] == '0') {
                foundZero = true;
            }

            if (i == chars.length - 1) continue;

            if (foundZero && chars[i] == '1') {
                flipToZero++;
            }

            minFlip = Math.min(minFlip, flipToZero + flipToOne[i]);
        }
        return minFlip;
    }
}
