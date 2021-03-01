package leetcode;

/**
 * @author Tempo
 */
public class GlobalAndLocalInversion {
    public boolean isIdealPermutation(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                if (arr[i - 1] - arr[i] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
