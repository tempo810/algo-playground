package leetcode;

/**
 * @author Tempo
 */
public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
