package leetcode;

/**
 * @author Tempo
 */
public class IsValidNumber {
    public boolean isNumber(String s) {
        char[] numberArray = s.toCharArray();
        if (!isValidFirstCharacter(numberArray[0])) {
            return false;
        }
        if (numberArray[0] == '.') {
            return numberArray.length > 1 && isValidDecimal(numberArray, 1) && Character.isDigit(numberArray[1]);
        }

        for (int i = 1; i < numberArray.length; i++) {
            if (Character.isDigit(numberArray[i])) {
                continue;
            } else if (numberArray[i] == '.') {
                return isValidDecimal(numberArray, i + 1) && (i != 1 || (numberArray.length > i + 1 || Character.isDigit(numberArray[0])));

            } else if (numberArray[i] == 'e' || numberArray[i] == 'E') {
                return isValidInteger(numberArray, i + 1) && (i != 1 || Character.isDigit(numberArray[0]));
            }
            return false;
        }

        return numberArray.length > 1 || Character.isDigit(numberArray[0]);
    }

    private boolean isValidInteger(char[] numberArray, int startIndex) {
        if (startIndex > numberArray.length - 1) {
            return false;
        }

        if (!Character.isDigit(numberArray[startIndex]) && (numberArray[startIndex] != '+' && numberArray[startIndex] != '-')) {
            return false;
        }

        for (int i = startIndex + 1; i < numberArray.length; i++) {
            if (!Character.isDigit(numberArray[i])) {
                return false;
            }
        }
        return numberArray.length - startIndex > 1 || Character.isDigit(numberArray[startIndex]);
    }

    private boolean isValidDecimal(char[] numberArray, int startIndex) {
        for (int i = startIndex; i < numberArray.length; i++) {
            if (numberArray[i] == 'e' || numberArray[i] == 'E') {
                return isValidInteger(numberArray, i + 1);
            }
            if (!Character.isDigit(numberArray[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isValidFirstCharacter(char c) {
        return checkSign(c) || c == '.' || Character.isDigit(c);
    }
}
