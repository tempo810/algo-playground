package leetcode.leetcode75;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tempo
 */
public class Dota2Senate {
    private static final String DIRE = "DIRE";
    private static final String RADIANT = "RADIANT";

    public String predictPartyVictory(String senate) {
        int numberOfDire = 0;
        int numberOfRadiant = 0;
        // dire = true. radiant = false
        Queue<Boolean> queue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                numberOfRadiant++;
                queue.add(false);
            } else {
                numberOfDire++;
                queue.add(true);
            }
        }

        int numberOfDireFutureBan = 0;
        int numberOfRadiantFutureBan = 0;
        while (numberOfDire > 0 && numberOfRadiant > 0) {
            final Boolean poll = queue.poll();
            if (poll) { // dire
                if (numberOfRadiantFutureBan > 0) {
                    numberOfRadiantFutureBan--;
                    numberOfDire--;
                } else {
                    numberOfDireFutureBan++;
                    queue.add(true);
                }
            } else { // radiant
                if (numberOfDireFutureBan > 0) {
                    numberOfDireFutureBan--;
                    numberOfRadiant--;
                } else {
                    numberOfRadiantFutureBan++;
                    queue.add(false);
                }
            }
        }
        return numberOfRadiant > 0 ? "Radiant" : "Dire";
    }
}
