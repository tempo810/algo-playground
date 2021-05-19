package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tempo
 */
public class FindDuplicateFileInSystem {
    // Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> tempResult = new HashMap<>();
        for (String path : paths) {
            int delimitIndex = path.indexOf(' ');
            String currentRoot = path.substring(0, delimitIndex);
            dfs(currentRoot, delimitIndex + 1, path, tempResult);
        }
        List<List<String>> results = new ArrayList<>();
        for (List<String> value : tempResult.values()) {
            if (value.size() > 1) {
                results.add(value);
            }
        }
        return results;
    }

    private void dfs(String currentRoot, int startPos, String path, Map<String, List<String>> tempResult) {
        int keyStart = path.indexOf('(', startPos + 1);
        String fileName = currentRoot + "/" + path.substring(startPos, keyStart);
        int keyEnd = path.indexOf(')', keyStart + 1);
        String key = path.substring(keyStart + 1, keyEnd);
        tempResult.computeIfAbsent(key, k -> new ArrayList<>()).add(fileName);
        int next = path.indexOf(' ', keyEnd);
        if (next != -1) {
            dfs(currentRoot, next + 1, path, tempResult);
        }
    }
}
