package leetcode;

/**
 * @author Tempo
 */
public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String num1, String num2) {
        int delimiter1 = signIndex(num1);
        int delimiter2 = signIndex(num2);

        int realValue1 = Integer.parseInt(num1.substring(0, delimiter1));
        int realValue2 = Integer.parseInt(num2.substring(0, delimiter2));

        int imaginary1 = imaginary(num1, delimiter1);
        int imaginary2 = imaginary(num2, delimiter2);

        int realResult = realValue1 * realValue2 - imaginary1 * imaginary2;
        int imaginaryResult = realValue1 * imaginary2 + realValue2 * imaginary1;
        return realResult + "+" + imaginaryResult + "i";
    }

    private int imaginary(String num, int startIndex) {
        int sign = num.charAt(startIndex + 1) == '-' ? -1 : 1;
        int index = sign == 1 ? startIndex + 1 : startIndex + 2;
        return sign * Integer.parseInt(num.substring(index, num.length() - 1));
    }

    private int signIndex(String num) {
        int index = 0;
        while (index < num.length()) {
            if (num.charAt(index) == '+') {
                return index;
            }
            index++;
        }
        return -1;
    }
}
