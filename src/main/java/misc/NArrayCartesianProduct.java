package misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Tempo
 */
public class NArrayCartesianProduct {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(get(new int[][]{{0, 2, 3}, {2, 3, 4}, {4, 5, 6, 7}})));

        NDimensionalArray array1 = new NDimensionalArray(new int[]{0, 2, 3}, new NDimensionalArray(new int[]{2, 3, 4}, null));
        NDimensionalArray array2 = new NDimensionalArray(new int[]{}, new NDimensionalArray(new int[]{4, 5, 6, 7}, null));
        System.out.println(Arrays.toString(get(array1, array2)));
    }

    public static int[] get(int[]... arrays) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        for (int[] array : arrays) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer val = queue.poll();
                for (int i : array) {
                    queue.add(val * i);
                }
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] get(NDimensionalArray... arrays) {
        Queue<Integer> products = new ArrayDeque<>();
        products.add(1);
        return helper(arrays, 0, products);
    }

    private static int[] helper(NDimensionalArray[] arrays, int i, Queue<Integer> products) {
        if (i == arrays.length) {
            return products.stream().mapToInt(Integer::intValue).toArray();
        }
        NDimensionalArray currentArray = arrays[i];
        addProducts(products, currentArray);
        return helper(arrays, i + 1, products);
    }

    private static void addProducts(Queue<Integer> products, NDimensionalArray currentArray) {
        if (currentArray.elements.length > 0) {
            int currentProductSize = products.size();
            for (int j = 0; j < currentProductSize; j++) {
                Integer val = products.poll();
                for (int element : currentArray.elements) {
                    products.add(val * element);
                }
            }
        }
        if (currentArray.child != null) {
            addProducts(products, currentArray.child);
        }
    }

    public static class NDimensionalArray {
        public final int[] elements;
        public final NDimensionalArray child;

        public NDimensionalArray(int[] elements, NDimensionalArray child) {
            this.elements = elements;
            this.child = child;
        }
    }
}
