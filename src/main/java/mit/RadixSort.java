package mit;

/**
 * @author Tempo
 */
public class RadixSort {
    public static String[] sort(String[] strings) {
        String[] output = strings;
        for (int i = strings[0].length() - 1; i >= 0; i--) {
            output = countingSort(output, i);
        }
        return output;
    }

    private static String[] countingSort(String[] strings, int position) {
        int[] chars = new int[52];
        for (String string : strings) {
            chars[string.charAt(position) - 'A']++;
        }
        for (int i = 1; i < chars.length; i++) {
            chars[i] += chars[i - 1];
        }

        String[] ret = new String[strings.length];
        for (int i = strings.length - 1; i >= 0; i--) {
            ret[chars[strings[i].charAt(position) - 'A']-- - 1] = strings[i];
        }
        return ret;
    }
}
