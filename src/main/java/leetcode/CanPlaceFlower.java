package leetcode;

/**
 * @author Tempo
 */
public class CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n == 1;
        }

        int remaining = n;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            remaining--;
        }

        for (int i = 1; i < flowerbed.length - 1 && remaining > 0; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                remaining--;
                flowerbed[i] = 1;
                i++;
            }
        }

        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            remaining--;
        }

        return remaining <= 0;
    }
}
