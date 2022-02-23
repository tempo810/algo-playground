package leetcode;

/**
 * @author Tempo
 */
public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        int colNumber = 0;
        char[] titleChars = columnTitle.toCharArray();
        for (int i = 0; i < titleChars.length; i++) {
            int i1 = titleChars[i] - 64;
            int i2 = (int) Math.pow(26, titleChars.length - i - 1);
            colNumber += i2 * i1;
        }
        return colNumber;
    }
}
