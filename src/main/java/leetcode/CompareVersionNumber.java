package leetcode;

/**
 * @author Tempo
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.min(v1.length, v2.length); i++) {
            int rev1 = Integer.parseInt(v1[i]);
            int rev2 = Integer.parseInt(v2[i]);
            if (rev1 != rev2) {
                return Integer.compare(rev1, rev2);
            }
        }

        if (v1.length > v2.length) {
            for (int i = v2.length; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) > 0) {
                    return 1;
                }
            }
        }

        if (v2.length > v1.length) {
            for (int i = v1.length; i < v2.length; i++) {
                if (Integer.parseInt(v2[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
