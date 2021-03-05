package leetcode;

/**
 * @author tempo
 */
public class DecodeWays {
    public int numDecodings(String s) {
        return decode(0, s);
    }

    private int decode(int start, String s) {
        if (s.charAt(start) == '0') {
            return 0;
        }

        int count = 0;
        int diff = s.length() - start;

        if (diff <= 2) {
            count++;
            if (diff != 1) {
                int doubleDigit = Integer.parseInt(s.substring(start, start + 2));
                if (doubleDigit >= 10 && doubleDigit <= 26) {
                    count++;
                }
            }
            return count;
        } else {
            for (int i = 0; i < 2; i++) {
                String value = s.substring(start, (start + i + 1));
                if (Integer.parseInt(value) <= 26) {
                    count += decode(start + i + 1, s);

                }
            }
        }
        return count;
    }
}
