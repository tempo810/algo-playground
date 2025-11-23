package leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tempo
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> survivors = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                survivors.addLast(asteroid);
            } else {
                boolean currentAsteroidIsDestroyed = false;
                while (!survivors.isEmpty()) {
                    final int lastAsteroid = survivors.getLast();
                    // same direction
                    if (lastAsteroid < 0) {
                        break;
                    } else if (lastAsteroid > -asteroid) {
                        currentAsteroidIsDestroyed = true;
                        break;
                    } else if (lastAsteroid == -asteroid) {
                        survivors.removeLast();
                        currentAsteroidIsDestroyed = true;
                        break;
                    } else {
                        survivors.removeLast();
                    }
                }
                if (!currentAsteroidIsDestroyed) {
                    survivors.addLast(asteroid);
                }
            }
        }
        return survivors.stream().mapToInt(Integer::intValue).toArray();
    }
}
