package leetcode;

/**
 * @author Tempo
 */
public class LuckyInteger {
    public int findLucky(int[] arr) {
        int[] frequency = new int[501];
        for (int i : arr) {
            frequency[i]++;
        }

        for (int i = frequency.length - 1; i > 0; i--) {
            if (frequency[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
