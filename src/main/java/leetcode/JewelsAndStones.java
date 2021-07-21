package leetcode;

/**
 * @author Tempo
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] jewel = new boolean[64];
        for (char c : jewels.toCharArray()) {
            jewel[c - 'A'] = true;
        }
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewel[c - 'A']) count++;
        }
        return count;
    }
}
