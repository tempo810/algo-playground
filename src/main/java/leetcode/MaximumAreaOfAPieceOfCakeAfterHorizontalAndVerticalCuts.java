package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHeight = 0;
        long prev = 0;
        for (int horizontalCut : horizontalCuts) {
            maxHeight = Math.max(horizontalCut - prev, maxHeight);
            prev = horizontalCut;
        }
        maxHeight = Math.max(h - prev, maxHeight);

        long maxWidth = 0;
        prev = 0;
        for (int verticalCut : verticalCuts) {
            maxWidth = Math.max(verticalCut - prev, maxWidth);
            prev = verticalCut;
        }
        maxWidth = Math.max(w - prev, maxWidth);
        long mod = (long) 1e9 + 7;
        return (int) ((maxHeight * maxWidth) % mod);
    }
}
