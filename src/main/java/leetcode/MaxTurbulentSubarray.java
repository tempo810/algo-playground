package leetcode;

/**
 * @author Tempo
 */
public class MaxTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int globalOptimal = 1;
        int currentOptimal = 1;
        Boolean findLarger = null;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                findLarger = null;
                currentOptimal = 1;
            } else {
                boolean currentIsSmaller = arr[i] < arr[i - 1];
                if (findLarger == null) {
                    findLarger = currentIsSmaller;
                    currentOptimal++;
                } else if (findLarger ^ currentIsSmaller) {
                    findLarger = !findLarger;
                    currentOptimal++;
                } else {
                    currentOptimal = 2;
                }
            }
            globalOptimal = Math.max(globalOptimal, currentOptimal);
        }
        return globalOptimal;
    }
}
