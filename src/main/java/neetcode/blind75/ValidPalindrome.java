package neetcode.blind75;

/**
 * @author tempo
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String sanitizedString = this.sanitize(s);
        boolean isEven = sanitizedString.length() % 2 == 0;
        int mid = sanitizedString.length() / 2;
        int right = isEven ? mid : mid + 1;
        int left = isEven ? right - 1 : mid - 1;
        while (left >= 0) {
            if (sanitizedString.charAt(left--) != sanitizedString.charAt(right++)) {
                return false;
            }
        }
        return true;
    }

    private String sanitize(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            final char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (c >= 'A' && c <= 'Z') {
                    sb.append((char) (c + 32));
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
