package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class AsteroidCollisionTest {
    private AsteroidCollision asteroidCollision;

    @BeforeEach
    void setUp() {
        asteroidCollision = new AsteroidCollision();
    }

    @Test
    void asteroidCollision() {
        Assertions.assertThat(this.asteroidCollision.asteroidCollision(new int[]{5, 10, -5})).isEqualTo(new int[]{5, 10});
        ;
    }
}