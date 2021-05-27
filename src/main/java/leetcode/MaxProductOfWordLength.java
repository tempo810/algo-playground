package leetcode;

/**
 * @author Tempo
 */
public class MaxProductOfWordLength {
    public int maxProduct(String[] words) {
        int[] hashes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                hashes[i] |= 1 << c - 'a';
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < hashes.length; i++) {
            for (int j = i + 1; j < hashes.length; j++) {
                if ((hashes[i] & hashes[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }
}
