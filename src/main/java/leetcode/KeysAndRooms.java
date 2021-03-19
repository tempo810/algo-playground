package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tempo
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> entered = new HashSet<>();
        return helper(0, rooms, entered);
    }

    private boolean helper(int roomNumber, List<List<Integer>> rooms, Set<Integer> entered) {
        entered.add(roomNumber);
        for (Integer room : rooms.get(roomNumber)) {
            if (!entered.contains(room)) {
                helper(room, rooms, entered);
            }
        }
        return entered.size() == rooms.size();
    }
}
