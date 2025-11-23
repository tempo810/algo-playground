package leetcode.leetcode75;

/**
 * @author tempo
 */
public class MinimumFlipToMakeAOrBEqualC {
    public int minFlips(int a, int b, int c) {
        int flip = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int cBit = (c >> i) & 1;
            if ((aBit | bBit) != cBit) {
                if (cBit == 1) {
                    flip++;
                } else {
                    flip += aBit == bBit ? 2 : 1;
                }
            }
        }
        return flip;
    }
}
