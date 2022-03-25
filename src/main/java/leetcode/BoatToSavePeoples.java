package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class BoatToSavePeoples {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int numberOfBoat = 0;
        int lo = 0;
        int high = people.length - 1;
        while (lo < high) {
            if (people[lo] + people[high] <= limit) {
                lo++;
            }
            high--;
            numberOfBoat++;
        }
        return lo == high ? numberOfBoat + 1 : numberOfBoat;
    }
}
