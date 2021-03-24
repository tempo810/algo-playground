package leetcode;

/**
 * @author Tempo
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        int v1Sum = 0;
        String[] v2 = version2.split("\\.");
        int v2Sum = 0;

        for (int i = 0; i < Math.min(v1.length, v2.length); i++) {
            int rev1 = Integer.parseInt(v1[i]);
            int rev2 = Integer.parseInt(v2[i]);
            if (rev1 > rev2) {
                return 1;
            }
            if (rev2 > rev1) {
                return -1;
            }
            v1Sum += rev1;
            v2Sum += rev2;
        }

        if (v1.length > v2.length) {
            for (int i = v2.length; i < v1.length; i++) {
                v1Sum += Integer.parseInt(v1[i]);
            }
        }

        if (v2.length > v1.length) {
            for (int i = v1.length; i < v2.length; i++) {
                v2Sum += Integer.parseInt(v2[i]);
            }
        }

        if (v1Sum == v2Sum) {
            return 0;
        }
        return v1Sum > v2Sum ? 1 : -1;
    }
}
