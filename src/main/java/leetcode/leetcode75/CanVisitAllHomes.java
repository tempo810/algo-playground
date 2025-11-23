package leetcode.leetcode75;

import java.util.List;

/**
 * @author tempo
 */
public class CanVisitAllHomes {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visited) {
        if (!visited[currentRoom]) {
            visited[currentRoom] = true;
            for (Integer nextRoomKey : rooms.get(currentRoom)) {
                dfs(rooms, nextRoomKey, visited);
            }
        }
    }
}
