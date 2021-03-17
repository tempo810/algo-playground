package leetcode;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author tempo
 */
public class GenerateRandomPointInACircle {

    private final double radius;
    private final double xCenter;
    private final double yCenter;

    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double randomX = xCenter + ThreadLocalRandom.current().nextFloat() * radius * (ThreadLocalRandom.current().nextBoolean() ? 1 : -1);
            double randomY = yCenter + ThreadLocalRandom.current().nextFloat() * radius * (ThreadLocalRandom.current().nextBoolean() ? 1 : -1);
            double distance = Math.sqrt(Math.pow(randomX - xCenter, 2) + Math.pow(randomY - yCenter, 2));
            if (distance <= radius) {
                return new double[]{randomX, randomY};
            }
        }
    }
}
