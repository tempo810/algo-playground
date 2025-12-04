package neetcode.blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class EncodeAndDecodeString {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append(' ');
        }
        return sb.substring(0, Math.max(0, sb.length() - 1));
    }

    public List<String> decode(String str) {
        if (str == null) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                result.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(str.charAt(i));
            }
        }

        result.add(sb.toString());

        return result;
    }
}
