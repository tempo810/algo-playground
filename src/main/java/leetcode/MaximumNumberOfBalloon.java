package leetcode;

/**
 * @author Tempo
 */
public class MaximumNumberOfBalloon {
    public int maxNumberOfBalloons(String text) {
        int[] characters = new int[26];
        for (char c : text.toCharArray()) {
            characters[c - 'a'] += 1;
        }

        int min = Math.min(characters['b' - 'a'], characters[0]);
        min = Math.min(characters['n' - 'a'], min);
        min = Math.min(characters['l' - 'a'] / 2, min);
        min = Math.min(characters['o' - 'a'] / 2, min);
        return min;
    }
}
