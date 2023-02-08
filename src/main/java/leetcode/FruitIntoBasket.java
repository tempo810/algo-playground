package leetcode;

/**
 * @author tempo
 */
public class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        int maxPickedTrees = 0;
        int currentPickedTrees = 0;
        int firstTreeType = -1;
        int secondTreeType = -1;
        int[] typeLastSeen = new int[2];

        for (int i = 0; i < fruits.length; i++) {
            int currentType = fruits[i];
            if (firstTreeType == -1 || currentType == firstTreeType) {
                firstTreeType = currentType;
                typeLastSeen[0] = i;
            } else if (secondTreeType == -1 || currentType == secondTreeType) {
                secondTreeType = currentType;
                typeLastSeen[1] = i;
            } else if (fruits[i - 1] == firstTreeType) {
                secondTreeType = currentType;
                currentPickedTrees = i - typeLastSeen[1] - 1;
                typeLastSeen[1] = i;
            } else {
                firstTreeType = secondTreeType;
                secondTreeType = currentType;
                currentPickedTrees = i - typeLastSeen[0] - 1;
                typeLastSeen[0] = typeLastSeen[1];
                typeLastSeen[1] = i;
            }
            currentPickedTrees++;
            maxPickedTrees = Math.max(maxPickedTrees, currentPickedTrees);
        }
        return maxPickedTrees;
    }
}
