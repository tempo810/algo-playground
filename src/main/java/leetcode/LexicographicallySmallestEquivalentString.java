package leetcode;

/**
 * @author tempo
 */
public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] union = new char[26];
        for (int i = 0; i < 26; i++) {
            union[i] = (char) ('a' + i);
        }
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for (int i = 0; i < s1Chars.length; i++) {
            union(s1Chars[i], s2Chars[i], union);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append(findRoot(c, union));
        }
        return sb.toString();
    }

    private void union(char charA, char charB, char[] union) {
        if (charA != charB) {
            char rootA = findRoot(charA, union);
            char rootB = findRoot(charB, union);
            if (rootA < rootB) {
                union[rootB - 'a'] = rootA;
            } else {
                union[rootA - 'a'] = rootB;
            }
        }
    }

    private char findRoot(char charA, char[] union) {
        if (union[charA - 'a'] == charA) {
            return charA;
        }
        return findRoot(union[charA - 'a'], union);
    }
}
