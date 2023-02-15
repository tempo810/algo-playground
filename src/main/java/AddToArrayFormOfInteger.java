import java.util.LinkedList;
import java.util.List;

/**
 * @author tempo
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();

        int remaining = k;
        boolean carry = false;
        for (int i = num.length - 1; i >= 0; i--) {
            int remainder;
            if (remaining > 0) {
                remainder = remaining % 10;
                remaining /= 10;
            } else {
                remainder = 0;
            }
            remainder += num[i];
            if (carry) {
                remainder++;
                carry = false;
            }
            result.addFirst(remainder % 10);
            if (remainder >= 10) {
                carry = true;
            }
        }

        while (remaining > 0) {
            int remainder = remaining % 10;
            remaining /= 10;
            if (carry) {
                remainder++;
                carry = false;
            }
            result.addFirst(remainder % 10);
            if (remainder >= 10) {
                carry = true;
            }
        }

        if (carry) {
            result.addFirst(1);
        }
        return result;
    }
}
