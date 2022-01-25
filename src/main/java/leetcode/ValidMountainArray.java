package leetcode;

/**
 * @author Tempo
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        boolean goingUp = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            } else if (arr[i] < arr[i + 1]) {
                if (!goingUp) {
                    return false;
                }
            } else {
                if (i == 0) {
                    return false;
                }
                goingUp = false;
            }
        }
        return !goingUp;
    }
}
