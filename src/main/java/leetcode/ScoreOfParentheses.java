package leetcode;

/**
 * @author Tempo
 */
public class ScoreOfParentheses {
    private int lastTrackedIndex = 0;

    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        return calculate(0, chars);
    }

    private int calculate(int index, char[] chars) {
        int score = 0;
        int waterMark = index;
        while (waterMark < chars.length - 1) {
            if (chars[waterMark] == ')') {
                break;
            }
            if (chars[waterMark + 1] == '(') {
                score += 2 * calculate(waterMark + 1, chars);
                waterMark = lastTrackedIndex + 1;
            } else {
                score++;
                waterMark += 2;
            }
        }
        lastTrackedIndex = waterMark;
        return score;
    }
}
