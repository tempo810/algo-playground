package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tempo
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> pair : pairs) {
            graph.computeIfAbsent(pair.get(0), key -> new ArrayList<>()).add(pair.get(1));
            graph.computeIfAbsent(pair.get(1), key -> new ArrayList<>()).add(pair.get(0));
        }

        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                List<Integer> indices = new ArrayList<>();
                List<Character> characters = new ArrayList<>();
                dfs(i, chars, visited, indices, characters, graph);
                Collections.sort(indices);
                Collections.sort(characters);

                for (int j = 0; j < indices.size(); j++) {
                    chars[indices.get(j)] = characters.get(j);
                }
            }
        }

        return new String(chars);
    }

    private void dfs(int index, char[] chars, boolean[] visited, List<Integer> indices, List<Character> characters, Map<Integer, List<Integer>> graph) {
        if (!visited[index]) {
            visited[index] = true;
            indices.add(index);
            characters.add(chars[index]);
            List<Integer> children = graph.get(index);
            if (children != null) {
                for (Integer child : children) {
                    dfs(child, chars, visited, indices, characters, graph);
                }
            }
        }
    }
}
