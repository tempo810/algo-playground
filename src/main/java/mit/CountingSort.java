package mit;

/**
 * @author Tempo
 */
public class CountingSort {
    public static int[] sort(int[] A, int k) {
        int[] output = new int[k + 1];
        for (int i : A) {
            output[i]++;
        }
        for (int i = 1; i < output.length; i++) {
            output[i] += output[i - 1];
        }
        int[] results = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            results[output[A[i]] - 1] = A[i];
            output[A[i]]--;
        }
        return results;
    }
}
