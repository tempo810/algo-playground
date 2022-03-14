package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Tempo
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> pathNodes = new ArrayDeque<>();
        char[] chars = path.toCharArray();
        int lastIndex = -1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                if (i - lastIndex > 1) {
                    String pathNode = new String(chars, lastIndex + 1, i - 1 - lastIndex);
                    processNode(pathNode, pathNodes);
                }
                lastIndex = i;
            }
        }

        if (lastIndex != chars.length - 1) {
            String pathNode = new String(chars, lastIndex + 1, chars.length - 1 - lastIndex);
            processNode(pathNode, pathNodes);
        }

        if (pathNodes.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!pathNodes.isEmpty()) {
            sb.append('/');
            sb.append(pathNodes.removeFirst());
        }
        return sb.toString();
    }

    private void processNode(String pathNode, Deque<String> pathNodes) {
        if (pathNode.equals("..")) {
            if (!pathNodes.isEmpty()) {
                pathNodes.removeLast();
            }

        } else if (!pathNode.equals(".")) {
            pathNodes.addLast(pathNode);
        }
    }
}
