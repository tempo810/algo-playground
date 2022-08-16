package leetcode;

/**
 * @author tempo
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        int[] appearances = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            appearances[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (appearances[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
