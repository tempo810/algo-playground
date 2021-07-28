package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Tempo
 */
public class RevealDeckInIncreasingOrder {
    //[2,3,4,5]
    // q = [5]
    // q = [4,5]
    // q = [5,3,4]
    // q = [5,3,4,2]

    // [2,4,3,5]
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = deck.length - 1; i > 0; i--) {
            queue.add(deck[i]);
            queue.add(queue.remove());
        }
        queue.add(deck[0]);

        for (int i = deck.length - 1; i >= 0; i--) {
            deck[i] = queue.remove();
        }
        return deck;
    }
}
