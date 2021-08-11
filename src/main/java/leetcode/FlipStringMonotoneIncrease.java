package leetcode;

/**
 * @author Tempo
 */
public class FlipStringMonotoneIncrease {
    public int minFlipsMonoIncr(String s) {
        int[] flipOne = new int[s.length()];
        int[] flipZero = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                flipZero[i] = 1;
            }
            if (i > 0) {
                flipZero[i] += flipZero[i - 1];
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                flipOne[i] = 1;
            }
            if (i < s.length() - 1) {
                flipOne[i] += flipOne[i + 1];
            }
        }

        int minSwap = Integer.MAX_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            minSwap = Math.min(minSwap, flipOne[i] + flipZero[i + 1]);
            minSwap = Math.min(minSwap, flipZero[i] + flipOne[i + 1]);
        }

        minSwap = Math.min(flipOne[0], minSwap);
        minSwap = Math.min(flipZero[flipZero.length - 1], minSwap);
        return minSwap;
    }
}
