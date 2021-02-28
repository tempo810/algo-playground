package mit;

/**
 * @author Tempo
 */
public class PolynomialEvaluation {
    // let k = poly length,  O(k ^ (k - 1 / 2))
    public static int naiveEval(int[] poly, int n) {
        int result = 0;
        for (int i = 0; i < poly.length - 1; i++) {
            int p = i;
            int current = n;
            while (p < poly.length - 2) {
                current *= n;
                p++;
            }
            result += poly[i] * current;
        }
        return result + poly[poly.length - 1];
    }

    // o(n)
    public static int hornerMethod(int[] poly, int n) {
        int result = poly[0];
        for (int i = 1; i < poly.length; i++) {
            result = result * n + poly[i];
        }
        return result;
    }
}
