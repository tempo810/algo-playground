package leetcode;

/**
 * @author tempo
 */
public class MinimumFlipToMakeAorBEqualC {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int shiftedA = shift(a, i);
            int shiftedB = shift(b, i);
            int shiftedC = shift(c, i);
            if ((shiftedA | shiftedB) != shiftedC) {
                if (shiftedC == 0 && shiftedA == 1 && shiftedB == 1) {
                    count++;
                }
                count++;
            }
        }
        return count;
    }

    private int shift(int number, int position) {
        return (number << position) >>> 31;
    }
}
