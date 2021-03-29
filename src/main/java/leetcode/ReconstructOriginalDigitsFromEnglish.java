package leetcode;

import java.util.List;

/**
 * @author Tempo
 */
public class ReconstructOriginalDigitsFromEnglish {
    private final List<String> digits = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    //0: zero, 1: one, 2: two, 3: three, 4: four, 5: five, 6: six, 7: seven, 8: eight, 9: nine
    public String originalDigits(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        int[] counts = new int[10];
        counts[0] = chars['z' - 'a'];
        counts[2] = chars['w' - 'a'];
        counts[4] = chars['u' - 'a'];
        counts[6] = chars['x' - 'a'];
        counts[8] = chars['g' - 'a'];
        counts[5] = chars['f' - 'a'] - counts[4];
        counts[7] = chars['v' - 'a'] - counts[5];
        counts[9] = chars['i' - 'a'] - counts[5] - counts[6] - counts[8];
        counts[1] = chars['o' - 'a'] - counts[4] - counts[2] - counts[0];
        counts[3] = chars['t' - 'a'] - counts[2] - counts[8];

        var sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
