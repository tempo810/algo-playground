package leetcode.leetcode75;

/**
 * @author tempo
 */
public class CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int placed = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    placed++;
                    i++;
                    if (placed >= n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
