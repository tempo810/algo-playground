package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tempo
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            char[] chars = email.toCharArray();
            int j = 0;
            for (; j < chars.length && chars[j] != '@' && chars[j] != '+'; j++) {
                char currentChar = chars[j];
                if (currentChar == '.') continue;
                sb.append(currentChar);
            }
            while (chars[j] != '@') {
                j++;
            }
            sb.append(chars, j, chars.length - j);
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}
