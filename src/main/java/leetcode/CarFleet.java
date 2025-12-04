package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = i;
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        int[] lastCar = null;
        int fleetSize = 0;

        for (int[] car : cars) {
            if (lastCar == null) {
                lastCar = car;
                fleetSize++;
            } else {
                if (calTime(lastCar[0], speed[lastCar[1]], target) < calTime(car[0], speed[car[1]], target)) {
                    fleetSize++;
                    lastCar = car;
                }
            }
        }
        return fleetSize;
    }

    private double calTime(int position, int speed, int target) {
        return (double) (target - position) / speed;
    }
}
