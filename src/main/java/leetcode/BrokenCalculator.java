package leetcode;

/**
 * @author Tempo
 */
public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int operation = 0;
        while (target != startValue) {
            if (target % 2 == 0 && target > startValue) {
                target /= 2;
            } else if (target > startValue) {
                target++;
            } else {
                operation += (startValue - target);
                break;
            }
            operation++;
        }
        return operation;
    }
}
