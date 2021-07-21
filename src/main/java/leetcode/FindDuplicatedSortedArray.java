package leetcode;

/**
 * @author Tempo
 */
public class FindDuplicatedSortedArray {
    public boolean containsDuplicated(int[] a, int[] b) {
        int indexA = 0;
        int indexB = 0;
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] == b[indexB]) {
                return true;
            }
            if (a[indexA] < b[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        return false;
    }
}
